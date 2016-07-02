var app = angular.module('Art' , [] );
app.controller('ArtController' , function( $scope , $http ) { 

	var articulo = get( 'articulo' );
	
	$scope.articulo = {};
	$scope.articulo.codigo = articulo; 
	$scope.articulos = [];
	$scope.i = 0;
	
	$scope.siguiente = function( ){
		
		if( $scope.i >= $scope.articulos.length ){
			return;
		}
		$scope.articulo.codigo = $scope.articulos[ $scope.i + 1 ].codigo;
		$scope.i = $scope.i + 1
		cargarArticulo( );
		
	}
	
	$scope.anterior = function( ){
		
		if( $scope.i <= 0 ){
			return;
		}
		$scope.articulo.codigo = $scope.articulos[ $scope.i - 1 ].codigo;
		$scope.i = $scope.i - 1;
		cargarArticulo( );
		
	}

	function cargarArticulo(){
		
		var prom = $http.get( "/api/articulos/informacion/" + $scope.articulo.codigo + "/" );
		
		prom.success( function( data , status , headers , config) {
			$scope.articulo = data;
	    });
		
		prom.error( function( data , status , headers , config ) {
			alert("No existe el genero");
		});
	}
	
	function cargarArticulos( ){
		var prom = $http.get( "/api/articulos/search/articulosgeneros" );
		
		prom.success(function(data, status, headers, config) {
			$scope.articulos = data;
			for( var i = 0 ; i < data.length ; i++ ){
				if( data[ i ].codigo == articulo ){
					$scope.i = i;
				}
			}
	    });
		
		prom.error( function( data , status , headers , config ) {
			alert("No existe el genero");
		});
	}
	cargarArticulos();
	cargarArticulo( );
});