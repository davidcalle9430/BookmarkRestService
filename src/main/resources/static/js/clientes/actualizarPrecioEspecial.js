/**
 * 
 */

var app = angular.module( 'clientesEspeciales' , []);
app.controller('ClientesEspecialesController', function($scope,$http) { 
	$scope.cliente = {};
	$scope.cliente.codigo = "";
	$scope.cliente.productos = []
	$scope.buscar = function(){
		var promesa = $http.get("/api/especia/search/findByCodigo?codigo="+$scope.cliente.codigo+"&projection=cliente");
		promesa.success(function(data, status, headers, config) {
			if(data._embedded.especias.length == 0 ){ alert("No es un cliente especial");}
			$scope.cliente.productos = data._embedded.especias;
			$scope.cliente.nombre = data._embedded.especias[ 0 ].clientes.razsoc;
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("Error al cargar!");
		});
	}
	$scope.editar = function( producto ){
		var producto = JSON.parse( JSON.stringify( producto ) );
		var url = "/api/especia";
		var promesa = $http.put( url , producto );
		promesa.success(function(data, status, headers, config) {
			console.log("Actualización correcta");
	    });
		promesa.error(function(data, status, headers, config) {
	        console.log("Error al actualizar");
	        console.log(data)
		});
		
	}
});