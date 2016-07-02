var app = angular.module('Art' , [] );
app.controller('ArtController' , function( $scope , $http ) { 

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
		
		var prom = $http.get( "/api/articulos/informacion/" + $scope.articulo.codigo + "/" );
		
		prom.success(function(data, status, headers, config) {
			console.log( data );
			$scope.articulo = data;
	    });
		
		prom.error( function( data , status , headers , config ) {
			alert("No existe el genero");
		});
	}
	
	cargarArticulo( );
});