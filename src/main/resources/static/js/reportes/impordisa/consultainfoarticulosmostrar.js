var app = angular.module('CardexArt' , [] );
app.controller('CardexArtController' , function( $scope , $http ) { 

	var articulo = get( 'articulo' );
	
	$scope.articulo = {};
	$scope.articulo.codigo = articulo; 
	
	
	$scope.siguiente = function( ){
		
		if( $scope.genero.codigo >= 100 ){
			return;
		}
		
		$scope.articulo.codigo = parseInt( $scope.articulo.codigo ) + 1;
		articulo = $scope.articulo.codigo; // mala practicaa pero ni modo
		$scope.articulo.nombre = "";
		cargarArticulo( );
		
	}
	
	$scope.anterior = function( ){
		
		if( $scope.genero.codigo <= 0 ){
			return;
		}
		
		$scope.articulo.codigo = parseInt( $scope.articulo.codigo ) - 1;
		articulo = $scope.articulo.codigo; // mala practicaa pero ni modo
		$scope.articulo.nombre = "";
		cargarArticulo( );
		
	}

	function cargarArticulo(){
		
		var prom = $http.get( "/api/generos/" +genero+ "/" );
		
		prom.success(function(data, status, headers, config) {
			$scope.genero.nombre = data.nombre;
			cargarTabla( );
	    });
		
		prom.error( function( data , status , headers , config ) {
			alert("No existe el genero");
		});
	}
	
	cargarArticulo( );
});