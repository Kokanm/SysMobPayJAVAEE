var webShopServices = angular.module('webShopServices', [ 'ngResource' ]);

/**
 * Storitev za nalaganje, naročil, uporabnikov in podrobnosti naročila
 */
webShopServices.factory('WebShopService', [
		'$resource',
		function($resource) {
			var service = {
				orders : $resource('rest/sysmobpay/:orderID', {
					orderId : '@id'
				}, {
				}),
				users : $resource('rest/users/:userID', {}, {

				}),
				orderDetails : $resource(
						'rest/sysmobpay/:orderId/postavke', {}, {
						})
			};
			return service;
		} ]);
