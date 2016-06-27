var myApp = angular.module('opciones-usuario-eliminar', []);
myApp.controller('appController',['$scope', '$http', function($scope, $http){
	
	var registro = get('registro');
	var url = "/api/rolesymenus/"+registro;
	$scope.cancelar = function(){
		history.go(-1);
	}
	
	var url = "/api/rolesymenus/"+get('registro');
	$scope.eliminar = function(){
		//location.href= url;
		$http.delete(url)
			.success(function (data, status, headers) {
				history.go(-2);
	        })
	        .error(function (data, status, header, config) {
	            alert('Error al eliminar el registro');
	        });
	}
	
	var codigo = get('codigo');		
}]);
