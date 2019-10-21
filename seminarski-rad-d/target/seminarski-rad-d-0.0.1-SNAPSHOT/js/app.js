var app = angular.module('myApp', [ 'ngRoute', 'datatables', 'ui.bootstrap' ]);

app.config(function($routeProvider, $locationProvider) {

	$routeProvider.when('/login', {
		templateUrl : 'login',
		controller : 'LoginCtrl',
		controllerAs : 'loginCtrl'
	}).when('/home', {
		templateUrl : 'home',
		controller : 'HomeCtrl',
		controllerAs : 'homeCtrl'
	}).when('/users', {
		templateUrl : 'users',
		controller : 'UsersCtrl',
		controllerAs : 'usersCtrl'
	}).when('/orders', {
		templateUrl : 'orders',
		controller : 'OrdersCtrl',
		controllerAs : 'ordersCtrl'
	}).when('/sales-units', {
		templateUrl : 'sales-units',
		controller : 'SalesUnitsCtrl',
		controllerAs : 'salesUnitsCtrl'
	}).otherwise({
		redirectTo : '/home'
	})
});