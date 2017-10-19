(function() {
	'use strict';

	angular.module('app')
			.controller('EmployeesController', EmployeesController);

	EmployeesController.$inject = [ '$http' ];

	function EmployeesController($http) {
		var vm = this;

		vm.employees = [];
		vm.getAllEmployees = getAllEmployees;

		init();

		function init() {
			getAllEmployees();
		}

		function getAllEmployees() {
			var url = "/employee";
			var allEmployees = $http.get(url);
			allEmployees.then(function(response) {
				vm.employees = response.data;
			});
		}

	}
})();