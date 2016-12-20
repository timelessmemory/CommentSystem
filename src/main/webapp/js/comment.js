var app = angular.module('app', []);

app.controller('mainController', ['$scope', 'httpService', function($scope, httpService) {
	var mockusers = [{
		"id" : "1",
		"username" : "li",
		"avatar" : "images/li.jpg"
	}, {
		"id" : "2",
		"username" : "mario",
		"avatar" : "images/mario.jpg"
	}, {
		"id" : "3",
		"username" : "timelessmemory",
		"avatar" : "images/timelessmemory.jpg"
	}, {
		"id" : "4",
		"username" : "smile",
		"avatar" : "images/smile.jpg"
	},]

	var currentUserIndex = 2;

	window.localStorage.setItem("id", mockusers[currentUserIndex].id);
	window.localStorage.setItem("username", mockusers[currentUserIndex].username);
	window.localStorage.setItem("avatar", mockusers[currentUserIndex].avatar);

	$scope.isShowComment = false;

	$scope.cmt = {
		fstlvlcmt : ""
	}

	var sayingID, flcId, slcId;

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

		var tmpLikes = $scope.saying.likes;
		tmpLikes = tmpLikes.join(",");

		var data = {
			id : sayingId,
			likes : tmpLikes
		};

		httpService.post("http://localhost:8080/saying/likes", data, function(data) {
			$scope.isShowLike = $scope.saying.likes.contains($scope.user.id);
		}, function(error) {
			console.log(error)
		})
	}

	$scope.showComment = function() {
		$scope.isShowComment = ! $scope.isShowComment;
	}

	$scope.firstComment = function(sayingId) {

		if ($scope.cmt.fstlvlcmt == "") {
			$('#hintDiv').fadeIn(300);
			
			setTimeout(function() {
				$('#hintDiv').fadeOut(300);
			}, 800);

			return;
		}

		var data = {
			sayingId : sayingId,
			commenter : $scope.user.username,
			avatar : $scope.user.avatar,
			commentContent : $scope.cmt.fstlvlcmt,
		}

		httpService.post("http://localhost:8080/comment/add/first", data, function(result) {
			data.id = result.id;
			data.commentTime = result.commentTime;
			$scope.saying.flcs.push(data)
			$scope.cmt.fstlvlcmt = "";
			$scope.isShowComment = false;
			console.log($scope.saying.flcs)
		}, function(error) {
			console.log(error)
		})
	}

	$scope.showSecondComment = function(comment, toWho) {
		if (!comment.isShowChildComment) {
			comment.scndlvlcmt = "@" + toWho + " ";
			comment.tmptoWho = toWho;
			comment.isShowChildComment = true;
		} else {
			if (toWho == comment.tmptoWho) {
				comment.isShowChildComment = false;
				comment.tmptoWho = "";
				comment.scndlvlcmt = "";
			} else {
				comment.scndlvlcmt = "@" + toWho + " ";
				comment.tmptoWho = toWho;
			}
		}
	}

	$scope.hideSecondComment = function(comment) {
		comment.isShowChildComment = false;
		comment.tmptoWho = "";
		comment.scndlvlcmt = "";
	}

	$scope.reply = function(sayingId, comment) {
		var scndlvlcmt = comment.scndlvlcmt;
		var str = "@" + comment.tmptoWho;
		
		if (scndlvlcmt == "" || $.trim(scndlvlcmt) == str) {
			$('#hintDiv').fadeIn(300);
			
			setTimeout(function() {
				$('#hintDiv').fadeOut(300);
			}, 800);

			return;
		}
		
		var cmt = "";

		if (scndlvlcmt.indexOf(str) >= 0) {
			cmt = scndlvlcmt.substr(scndlvlcmt.indexOf(str) + str.length)
		} else {
			cmt = scndlvlcmt;
		}

		var data = {
			sayingId : sayingId,
			flcId : comment.id,
			replier : $scope.user.username,
			toCommenter : comment.tmptoWho,
			replyContent :  cmt
		}

		httpService.post("http://localhost:8080/comment/add/second", data, function(result) {
			comment.isShowChildComment = false;
			comment.scndlvlcmt = "";
			data.id = result.id;
			data.replyTime = result.replyTime;

			angular.forEach($scope.saying.flcs, function(item) {
				if (item.id == comment.id) {
					item.slcs.push(data);
				}
			})
		}, function(error) {
			console.log(error)
		})
	}

	$scope.deletefslcmt = function(sayingId, firstlvlId) {
		$('#commentModal').modal("show");
		sayingID = sayingId;
		flcId = firstlvlId;
	}

	$scope.confirm = function() {
		$('#commentModal').modal("hide");

		var url = "http://localhost:8080/comment/delete/first/" + sayingID + "/" + flcId;
		
		httpService.get(url, {}, function(data) {
			//local delete comment
			angular.forEach($scope.saying.flcs, function(item, index) {
				if (item.id == flcId) {
					$scope.saying.flcs.splice(index, 1);
				}
			})
			sayingID = "";
			flcId = "";
		}, function(error) {
			console.log(error)
		})
	}

	$scope.deletescndcmt = function(sayingId, firstlvlId, secondlvlId) {
		$('#slcModal').modal("show");
		sayingID = sayingId;
		flcId = firstlvlId;
		slcId = secondlvlId;
	}

	$scope.confirmSlc = function() {
		$('#slcModal').modal("hide");

		var url = "http://localhost:8080/comment/delete/second/" + sayingID + "/" + slcId;
		
		httpService.get(url, {}, function(data) {
			//local delete second level comment
			angular.forEach($scope.saying.flcs, function(item) {
				if (item.id == flcId) {
					angular.forEach(item.slcs, function(slc, index) {
						if (slc.id == slcId) {
							item.slcs.splice(index, 1);
						}
					})
				}
			})
			sayingID = "";
			flcId = "";
			slcId = "";
		}, function(error) {
			console.log(error)
		})
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