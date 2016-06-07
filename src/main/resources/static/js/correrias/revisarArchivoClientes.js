var app = angular.module( 'Correrias' , []);
/**
 * funciton controladora de la pagina con el mismo nombre
 */
app.controller('CorreriaController', function($scope,$http) { 
	$scope.cliente = {};
	
	$scope.cargar = function(){
		var promesa = $http.get("/api/clientes?projection=RotulacionCorreria&size=9999&sort=ciudad.ciudad,asc");
		promesa.success(function(data, status, headers, config) {
			$scope.cliente.lista = data._embedded.clientes;
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("Error al cargar!");
		});
	}
	
	$scope.actualizar = function( cliente ){
		var promesa = $http.post( "/api/clientes/actualizar/correria", cliente );
		promesa.success( function( data , status , headers , config ) {
			alert("Actualización Correta")
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("Error al actualizar");
		});
	} 
	$scope.cargar();
});