'use strict';

/**
 * Definicija kontrolerjev
 */

var ordersControllers = angular.module('ordersControllers', []);

ordersControllers.controller('HomeCtrl', [ '$scope', 'WebShopService',
		function($scope, WebShopService) {
			$scope.orders = WebShopService.orders.query();
		} ]);

ordersControllers.controller('OrdersCtrl', [ '$scope', 'WebShopService',
		function($scope, WebShopService) {
			$scope.orders = WebShopService.orders.query();
		} ]);

/**
 * Kontroler podrobnosti enega naročila
 */
ordersControllers.controller('OrdersDetailCtrl', [ '$scope', '$routeParams',
		'WebShopService', function($scope, $routeParams, WebShopService) {

			/**
			 * Naloži naročilo
			 */
			$scope.loadOrder = function() {
				$scope.order = WebShopService.orders.get({
					orderID : $routeParams.orderID
				});
			};

			$scope.loadOrder();

			/**
			 * Ko se podrobnosti uspešno naložijo, naloži še podrobnosti Usera
			 * ter postavke naročila
			 */
			$scope.$watch('order', function(oldValue, newValue) {
				if (!newValue) {
					$scope.User = null;
					$scope.orderDetails = null;
					return;
				}
				newValue.$promise.then(function() {
					$scope.User = WebShopService.users.get({
						userID : $scope.order.User.id
					});
				});
				newValue.$promise.then(function() {
					$scope.orderItems = WebShopService.orderDetails.query({
						orderID : $scope.order.id
					});
				});
			});
			
			/**
			 * Opisi statusov pri prikazu drop-down menija
			 */
			$scope.orderStatuses = [ {
				'value' : 'dostava',
				'text' : 'Naročilo v dostavi'
			}, {
				'value' : 'v_pripravi',
				'text' : 'Naročilo v pripravi'
			} ];

			/**
			 * Metode za obravnavo klikov na gumb uredi/shrani/prekliči
			 */
			$scope.startEditing = function() {
				var order = $scope.order;
				$scope.tempOrder = angular.copy(order);
				$scope.editing = true;
			};

			$scope.cancelEditing = function() {
				$scope.tempOrder = null;
				$scope.editing = false;
				$scope.errorMessage = null;
			};

			$scope.save = function() {
				$scope.tempOrder.$save(function(o, putResponseHeaders) {
					$scope.order = o;
					$scope.tempOrder = null;
					$scope.editing = false;
					$scope.errorMessage = null;
				}, function(data, status, headers, config) {
					$scope.errorMessage = 'Shranjevaje ni uspelo.';
				});

			};
		} ]);
