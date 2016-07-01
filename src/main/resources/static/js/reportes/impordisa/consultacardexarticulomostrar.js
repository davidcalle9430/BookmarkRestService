var app = angular.module('CardexArt' , [] );
app.controller('CardexArtController' , function( $scope , $http ) { 

	var genero = get( 'genero' );
	var fecha = get( 'fecha' );
	
	$scope.genero = {};
	$scope.genero.codigo = genero; 
	$scope.genero.fecha = formatearFechaISO( fecha );
	$scope.lista = [ ];
	
	
	$scope.siguiente = function( ){
		
		if( $scope.genero.codigo >= 100 ){
			return;
		}
		$scope.genero.codigo = parseInt( $scope.genero.codigo ) + 1;
		genero = $scope.genero.codigo; // mala practicaa pero ni modo
		$scope.genero.nombre = "";
		$scope.lista = [];
		cargarGenero( );
		
	}
	
	$scope.anterior = function( ){
		
		if( $scope.genero.codigo <= 0 ){
			return;
		}
		
		$scope.genero.codigo = parseInt( $scope.genero.codigo ) - 1;
		genero = $scope.genero.codigo; // mala practicaa pero ni modo
		$scope.genero.nombre = "";
		$scope.lista = [];
		cargarGenero( );
		
	}
	
	function cargarTabla( ){
		var url = "/api/kardexi/articulo/?codigo=" 
				+ $scope.genero.codigo 
				+ "&fecha="+$scope.genero.fecha;
		var prom = $http.get( url );
		prom.success(function(data, status, headers, config) {
			for( var i = 0 ; i < data.length ; i++ ){
				data[ i ].entrada = data[ i ].tipo == 'E' ? data[ i ].cantidad : '';
				data[ i ].salida = data[ i ].tipo == 'S' ? data[ i ].cantidad : '';
				data[ i ].fecha = formatearFecha( data[ i ].fecha );
				console.log( data[ i ] );
			}
			$scope.lista = data;
	    });
		prom.error( function( data , status , headers , config ) {
			//no pasa nada no pasa nada
		});
	}
	
	function cargarGenero(){
		
		var prom = $http.get( "/api/generos/" +genero+ "/" );
		
		prom.success(function(data, status, headers, config) {
			$scope.genero.nombre = data.nombre;
			cargarTabla( );
	    });
		
		prom.error( function( data , status , headers , config ) {
			alert("No existe el genero");
		});
	}
	
	cargarGenero( );
});