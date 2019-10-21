var app = angular.module('myApp');

app.factory('sessionService', function sessionService($http, $log) {
	
	var loggedUser;

	var getLoggedUser = function() {
		return $http.get('/seminarski-rad-d/user-login').then(function(response) {
			loggedUser = response.data;
			$log.info(response);
		});
	}

	sessionService.login = function(config) {
		return $http.post('login', '', config).then(function(response) {
			return getLoggedUser();
		}).then(function(response){
			$log.info(response);
		});
	}
	
	sessionService.isAuthorised = function(role) {
		if (loggedUser == null) {
			return false;
		}
		for (var i = 0; i < loggedUser.authorities.length; i++) {
			if (loggedUser.authorities[i].authority == role) {
				return true;
			}
		}
		return false;
	}

	sessionService.getUser = function() {
		return loggedUser;
	};

	return sessionService;
});

app.factory('UserService', function userService($http, $log) {
	
	userService.getAllUsers = function() {
        return $http.get('/seminarski-rad-d/user');
    }
	
	userService.updateUser = function(user, id) {
        return $http.put('/seminarski-rad-d/user' + id, user);
    }
	
	userService.getRoles = function() {
		return $http({
			method : 'GET',
			url : '/seminarski-rad-d/roles'
		});
	}
	
	userService.getSalesUnits = function() {
		return $http({
			method : 'GET',
			url : '/seminarski-rad-d/salesUnits'
		});
	}
	
	userService.createUser = function(user) {
        return $http.post('/seminarski-rad-d/user', user);
    }
	
	userService.deleteUser = function(id) {
       return $http.delete('/seminarski-rad-d/user' + id);
    }
	
	return userService;
});

app.factory('SalesUnitService', function salesUnitService($http, $log) {
	
	salesUnitService.getAllSalesUnits = function() {
        return $http.get('/seminarski-rad-d/user');
    }
	
	return salesUnitService;
});