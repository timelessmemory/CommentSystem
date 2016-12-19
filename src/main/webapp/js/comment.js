var app = angular.module('app', []);

app.controller('mainController', ['$scope', 'httpService', function($scope, httpService) {
	window.localStorage.setItem("id", "1");
	window.localStorage.setItem("username", "mario");
	window.localStorage.setItem("avatar", "images/mario.jpg");

	$scope.isShowComment = false;
	$scope.isShowChildComment = false;
	$scope.commment = {
		fstlvlcmt : "",
		scndlvlcmt : ''
	}

	var tmptoWho = '';

	//current user information
	$scope.user = {
		id : window.localStorage.getItem("id"),
		username : window.localStorage.getItem("username"),
		avatar : window.localStorage.getItem("avatar")
	}

	httpService.get("http://localhost:8080/saying/get/comment/1", {}, function(data) {
		$scope.saying = data;
		$scope.saying.likes = $scope.saying.likes.split(",")[0] == "" ? [] : $scope.saying.likes.split(",");
		$scope.isShowLike = $scope.saying.likes.contains($scope.user.id);
	}, function(error) {
		console.log(error)
	})

	$scope.like = function(sayingId) {
		if ($scope.saying.likes.contains($scope.user.id)) {
			$scope.saying.likes.splice($scope.saying.likes.indexOf($scope.user.id), 1);
		} else {
			$scope.saying.likes.push($scope.user.id)
		}

		$scope.saying.likes = $scope.saying.likes.join(",");

		var data = {
			id : sayingId,
			likes : $scope.saying.likes
		};

		httpService.post("http://localhost:8080/saying/likes", data, function(data) {
			$scope.saying.likes = $scope.saying.likes.split(",")[0] == "" ? [] : $scope.saying.likes.split(",");
			$scope.isShowLike = $scope.saying.likes.contains($scope.user.id);
		}, function(error) {
			console.log(error)
		})
	}

	$scope.showComment = function() {
		$scope.isShowComment = ! $scope.isShowComment;
	}

	$scope.firstComment = function(sayingId) {
		if ($scope.commment.fstlvlcmt == "") {
			return;
		}

		var data = {
			sayingId : sayingId,
			commenter : $scope.user.username,
			avatar : $scope.user.avatar,
			commentContent : $scope.commment.fstlvlcmt,
		}

		httpService.post("http://localhost:8080/comment/add/first", data, function(result) {
			data.id = result.id;
			data.commentTime = result.commmentTime;
			$scope.saying.flcs.push(data)
			$scope.commment.fstlvlcmt = "";
			$scope.isShowComment = false;
		}, function(error) {
			console.log(error)
		})
	}

	$scope.showSecondComment = function(toWho) {
		if (!$scope.isShowChildComment) {
			$scope.commment.scndlvlcmt = "@" + toWho + " ";
			tmptoWho = toWho;
			$scope.isShowChildComment = true;
		} else {
			if (toWho == tmptoWho) {
				$scope.isShowChildComment = false;
				tmptoWho = "";
				$scope.commment.scndlvlcmt = "";
			} else {
				$scope.commment.scndlvlcmt = "@" + toWho + " ";
				tmptoWho = toWho;
			}
		}
	}

	$scope.hideSecondComment = function() {
		$scope.isShowChildComment = false;
		tmptoWho = "";
		$scope.commment.scndlvlcmt = "";
	}

	$scope.reply = function() {
		var scndlvlcmt = $scope.commment.scndlvlcmt;
		var str = "@" + tmptoWho;
		
		console.log(scndlvlcmt.substr(scndlvlcmt.indexOf(str) + str.length))
		console.log(tmptoWho)
		$scope.commment.scndlvlcmt = ""
	}

	$scope.deletefslcmt = function(firstlvlId) {
		
		var url = "http://localhost:8080/comment/delete/" + $scope.saying.id + "/" + firstlvlId;
		
		httpService.get(url, {}, function(data) {
			
		}, function(error) {
			console.log(error)
		})
	}

	$scope.deletescndcmt = function(secondlvlId) {

	}

}]);

app.factory('httpService', ['$http', function($http) {
  return {
    get : function(url, params, successCallback, errorCallback) {
        $http({
            url : url,
            method : 'get',
            data : $.param(params),
            headers : { 'Content-Type': 'application/x-www-form-urlencoded' },
            responseType : 'json'
        })
        .success(successCallback)
        .error(errorCallback);
    },
    post : function(url, params, successCallback, errorCallback) {
      $http({
            url : url,
            method : 'post',
            data : $.param(params),
            headers : { 'Content-Type': 'application/x-www-form-urlencoded' },
            responseType : 'json'
      })
      .success(successCallback)
      .error(errorCallback);
    }
  }
}]);

Array.prototype.contains = function(obj) {
    var i = this.length;

    while (i--) {
        if (this[i] === obj) {
            return true;
        }
    }
    return false;
}