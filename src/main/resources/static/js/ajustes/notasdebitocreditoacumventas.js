var app = angular.module( 'Ajustes' , []);

/**
 * funcion controladora de la pagina con el mismo nombre
 */
app.controller('AjustesController', function( $scope , $http ) { 
	$scope.carteras = [{}];
	
	$scope.validarFila = function( cartera ){
		cartera.tipo = cartera.tipo.toUpperCase();
		cartera.nat = cartera.nat.toUpperCase();
	}
	
	/**
	 * funcion que valida si es la ultima fila con el fin de saber si es encesario agregar o no
	 * una nueva fila
	 */
	function esUltimo( cartera , ultimo ){
		return cartera.tipo == ultimo.tipo;
	}
	/**
	 * funcion  que agrega una nueva fila
	 */
	$scope.agregarFila = function( $event , producto ){
		if( esUltimo( producto , $scope.carteras[ $scope.carteras.length - 1 ] ) ){
			console.log( $event.keyCode );
			if( $event.keyCode == 9 ){ // OPRIME TAB
				$scope.carteras.push( { } ); // se incializa una fila vacia
			}
		}
	}
	
	$scope.incorporar = function(){
		var url = "/api/ajustes/notadebcredacumventas/";
		var promesa = $http.post( url , $scope.carteras );
		promesa.success( function(data, status, headers, config) {
			alert("Registros cargados con Éxito");
	    });
		promesa.error( function(data, status, headers, config) {
	        alert("No existen registros a cargar");
		});
	}
});