'use strict';

var ordersApp = angular.module('ordersApp', [ 'ngRoute', 'ordersControllers',
		'webShopServices' ]);

/**
 * Konfiguracija routerja
 */
ordersApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'templates/home/home.tpl.html',
		controller : 'HomeCtrl'
	}).when('/orders', {
		templateUrl : 'templates/orders/orders.tpl.html',
		controller : 'OrdersCtrl'
	}).when('/orders/:orderID', {
		templateUrl : 'templates/orders/order-detail.tpl.html',
		controller : 'OrdersDetailCtrl'
	}).otherwise({
		redirectTo : '/home'
	});
} ]);

/**
 * Za določanje izbranega tab-a v index.xhtml
 */
ordersApp.run([ '$rootScope', '$location', function($rootScope, $location) {
	$rootScope.isActive = function(url) {
		if ($location.path().indexOf(url) !== -1) {
			return true;
		} else {
			return false;
		}
	};
} ]);

/**
 * Preimenovanje statusa
 */
ordersApp.filter('statusFilter', function() {
	return function(input) {
		if (input === 'v_pripravi') {
			return 'Naročilo v pripravi';
		} else if (input === 'dostava') {
			return 'Naročilo v dostavi';
		} else {
			return 'Nedefinirano stanje naročila';
		}
	};
});
