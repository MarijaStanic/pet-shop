var app = angular.module('myApp');

app.directive('convertToNumber', function() {
	return {
		require : 'ngModel',
		link : function(scope, element, attrs, ngModel) {
			ngModel.$parsers.push(function(val) {
				return parseInt(val, 10);
			});
			ngModel.$formatters.push(function(val) {
				return '' + val;
			});
		}
	};
});

app.directive('modalViewUrl', function($uibModal) {

	return {
		restrict : 'A',
		link : function($scope, element, attrs) {

			element.bind('click', function() {
				var templateUrl = attrs.modalViewUrl;
				var modalInstance = $uibModal.open({
					size : attrs.size,
					templateUrl : templateUrl,
					controller : attrs.modalController,
					scope: $scope,
					resolve : {
						data : function() {
							return angular.copy($scope.$eval(attrs.object));
						}
					}
				});
			});
		}
	};
});