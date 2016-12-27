var app = angular.module('app', []);

app.controller('mainController', ['$scope', function($scope) {
	window.localStorage.setItem("id", "1");
	window.localStorage.setItem("username", "li");
	window.localStorage.setItem("avatar", "images/li.jpg");

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

	$scope.saying = {
		sayingId : "1",
		author : "timelessmemory",
		avatar : "images/timelessmemory.jpg",
		createTime : "2016-12-12 14:00",
		sayingContent : "Hello, everyone.",
		likes : "",
		comments : [{
			firstlvlId : "1",
			commenter : "mario",
			avatar : "images/mario.jpg",
			commentContent : "good saying",
			commentTime : "2016-12-12 14:01",
			secondlvlComments : [{
				secondlvlId : "1",
				replier : "smile",
				toCommenter : "mario",
				replyContent : "i think so, too.",
				replyTime : "2016-12-12 14:02"
			}]
		}]
	}

	$scope.saying.likes = $scope.saying.likes.split(",")[0] == "" ? [] : $scope.saying.likes.split(",");
	$scope.isShowLike = $scope.saying.likes.contains($scope.user.id);

	$scope.like = function(sayingId) {
		if ($scope.saying.likes.contains($scope.user.id)) {
			$scope.saying.likes.splice($scope.saying.likes.indexOf($scope.user.id), 1);
		} else {
			$scope.saying.likes.push($scope.user.id)
		}

		console.log(sayingId)
		$scope.saying.likes = $scope.saying.likes.join(",");
		console.log($scope.saying.likes)

		// $scope.saying.likes = $scope.saying.likes.split(",")[0] == "" ? [] : $scope.saying.likes.split(",");
		// $scope.isShowLike = $scope.saying.likes.contains($scope.user.id);
	}

	$scope.showComment = function() {
		$scope.isShowComment = ! $scope.isShowComment;
	}

	$scope.firstComment = function(sayingId) {
		console.log($scope.commment.fstlvlcmt)
		console.log(sayingId)
		// $scope.commment.fstlvlcmt = ""
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

	$scope.deletefstcmt = function(firstlvlId) {
		
	}

	$scope.deletescndcmt = function(secondlvlId) {

	}

}]);

app.factory('httpService', ['$http', function($http) {
  return {
    get : function(url, params, successCallback, errorCallback) {
        $http({
            url : url + "?" + $.param(params),
            method : 'get',
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
