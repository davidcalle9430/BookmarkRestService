var app = angular.module( 'Ajustes' , []);
/**
 * funciton controladora de la pagina con el mismo nombre
 */
app.controller('AjustesController', function( $scope , $http ) { 
	$scope.genero = {};
	$scope.genero.articulos = [];
	$scope.buscar = function( ){
		
		if( $scope.genero == "" ){
			$scope.genero = 0;
			return;
		}
		var codigo = $scope.genero.codigo.substring( 0 , 3 );
		
		var promesa = $http.get( "/api/generos/" + codigo );
		promesa.success(function(data, status, headers, config) {
			
			$scope.genero.nombre = data.nombre;
			
			var prom = $http.get( "/api/articulos/genero/" +codigo+ "/" );
			prom.success(function(data, status, headers, config) {
				$scope.genero.articulos = data;
		    });
			prom.error(function(data, status, headers, config) {
		        alert("No existe el articulo");
			});
			
			
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("No existe el articulo");
		});
		
	}
});