var app = angular.module('myApp');

app.controller('IndexCtrl', [ '$location', 'sessionService', '$rootScope',
		function($location, sessionService, $rootScope) {

			var self = this;

			if (!$rootScope.logged) {
				$location.path('/login');
			} else {
				$location.path('/home');
			}

			self.isActive = function(viewLocation) {
				var active = (viewLocation === $location.path());
				return active;
			};

			self.isAuthorised = function(allowedRoles) {
				var roles = allowedRoles.split(',');
				for (var i = 0; i < roles.length; i++) {
					allowed = sessionService.isAuthorised(roles[i]);
					if (allowed) {
						return true;
					}
				}
				return false;
			}

			self.logout = function() {
				sessionService.logout().then(function() {
					$location.path('/login');
					$rootScope.logged = false;
				})
			}

		} ]);

app.controller('LoginCtrl', [ '$rootScope', '$http', '$location',
		'sessionService',
		function($rootScope, $http, $location, sessionService) {

			var vm = this;
			$rootScope.error = false;

			vm.login = function() {
				vm.loading = true;
				var config = {
					params : {
						username : vm.username,
						password : vm.password
					}
				}
				sessionService.login(config).then(function(response) {
					vm.loading = false;
					$rootScope.logged = true;
					$location.path('/home');
				}, function(response) {
					vm.loading = false;
					$rootScope.logged = false;
					$rootScope.error = true;
				});
			}
		} ]);

app.controller('HomeCtrl', [
		'UserService',
		'sessionService',
		function(UserService, sessionService) {

			var self = this;
			self.error = false;
			self.showMessage = false;
			self.loggedUser = sessionService.getUser();

			self.updateUser = updateUser;
			function updateUser(toUpdate) {
				if (toUpdate == 'email') {
					if (self.email == null) {
						self.error = true;
						self.showMessage = true;
						return;
					}
					self.loggedUser.email = self.email;
				} else {
					if (self.password == null) {
						self.error = true;
						self.showMessage = true;
						return;
					}
					self.loggedUser.password = self.password;
				}
				UserService.updateUser(self.loggedUser, self.loggedUser.id)
						.then(function() {
							self.error = false;
							self.showMessage = true;
						}, function() {
							self.error = true;
							self.showMessage = true;
						});
			}
		} ]);

app.controller('UsersCtrl', [ 'UserService', function(UserService) {

	var self = this;
	self.data = UserService.data;

	self.deleteUser = function(id) {
		UserService.deleteUser(id);
	}

} ]);

app.controller('SalesUnitsCtrl', [ 'SalesUnitService', '$location',
		'ProductService',
		function(SalesUnitService, $location, ProductService) {

			var self = this;
			self.data = SalesUnitService.data;

			self.deleteSalesUnit = function(id) {
				SalesUnitService.deleteSalesUnit(id);
			}

			self.view = function(path) {
				$location.path(path);
			}

			self.setSalesUnit = function(salesUnit) {
				ProductService.salesUnit = salesUnit;
			}
		} ]);

app.controller('CustomersCtrl', [ 'CustomerService', 'OrderService',
		function(CustomerService, OrderService) {

			var self = this;
			self.data = CustomerService.data;

			CustomerService.getCustomers();

			self.deleteCustomer = function(id) {
				CustomerService.deleteCustomer(id);
			}

			self.setSelectedCustomer = function(customer) {
				OrderService.customer = customer;
			}
		} ]);

app.controller('StocksCtrl', [ 'StockService', '$routeParams', '$location',
		function(StockService, $routeParams, $location) {

			var self = this;
			self.data = StockService.data;

			if ($location.path() == '/stocks') {
				StockService.salesUnitId = null;
				StockService.getStocks();
			} else {
				StockService.salesUnitId = $routeParams.id;
				StockService.getStocksForSalesUnit($routeParams.id);
			}

			self.deleteStock = function(id, index) {
				StockService.deleteStock(id, index);
			}

			self.checkPath = function(path) {
				if ($location.path() === '/stocks') {
					return true;
				}
				return false;
			}
		} ]);

app.controller('ProductsCtrl', [ 'ProductService', 'StockService',
		function(ProductService, StockService) {

			var self = this;
			self.data = ProductService.data;

			ProductService.getProducts();

			self.deleteProduct = function(id) {
				console.log('deleting');
				ProductService.deleteProduct(id);
			}

			self.setSelectedProduct = function(product) {
				StockService.product = product;
				// console.log('in stockservice', StockService.product);
			}
		} ]);

app.controller('SuppliersCtrl', [ 'SupplierService', 'ProductService',
		function(SupplierService, ProductService) {

			var self = this;
			self.data = SupplierService.data;

			SupplierService.getSuppliers();

			self.deleteSupplier = function(id) {
				SupplierService.deleteSupplier(id);
			}

			self.setSelectedSupplier = function(supplier) {
				ProductService.supplier = supplier;
			}
		} ]);

app.controller('OrdersCtrl', [ 'OrderService', function(OrderService) {

	var self = this;
	self.data = OrderService.data;

} ]);

app.controller('TabCtrl', function() {

	var self = this;
	self.steps = [ 'one', 'two' ];
	self.step = 0;

	self.isCurrentStep = function(step) {
		return self.step === step;
	}

	self.setCurrentStep = function(step) {
		self.step = step;
	}

	self.getCurrentStep = function() {
		return self.steps[self.step];
	}

	self.isFirstStep = function() {
		return self.step === 0;
	}

	self.isLastStep = function() {
		return self.step === (self.steps.length - 1);
	}

	self.getNextLabel = function() {
		return (self.isLastStep()) ? 'Submit' : 'Next';
	}

	self.handlePrevious = function() {
		self.step -= (self.isFirstStep()) ? 0 : 1;
	}
});