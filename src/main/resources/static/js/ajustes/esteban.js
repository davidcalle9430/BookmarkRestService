/**
 * 
 */

var app = angular.module( 'Esteban' , []);
/**
 * funcion controladora de la pagina con el mismo nombre
 */
app.controller('EstebanController', function( $scope , $http ) { 
	
	
	$scope.persona = {};
	$scope.persona.textos = [];
	
	
	$scope.mostrar = function( ){
		alert( JSON.stringify( $scope.persona ));
	}
	
	function inicializar(){
		
		var url = "/api/textosFactura";
		var promesa = $http.get( url );	
		promesa.success( function(data, status, headers, config) {
			$scope.persona.textos = data._embedded.textosFactura;
	    });
		promesa.error( function(data, status, headers, config) {
	        alert("error");
		});
	}
	
	inicializar();
	
	
	
});