var app = angular.module( 'Cartera' , []);
var TmpFact = null;
/**
 * funciton controladora de la pagina con el mismo nombre
 */
app.controller('CarteraController', function($scope,$http) { 
	//inicializacion de variables
	$scope.cartera = {};
	$scope.causales = {};
	
	
	
	
	function cargarFormulario(){
		$scope.cartera.fecha = formatearFecha ( darFechaActual() );
		/**
		 * obtencion del numero de factura
		 */
		var promesa = $http.get( "/api/nfact/1" );
		promesa.success( function( data , status , headers , config ) {
			$scope.nfact = data;
			$scope.cartera.numero = data.recibocaja;
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("Error al actualizar");
		});
		
		/**
		 * obtencion de los causales
		 */
		var promesa = $http.get( "/api/causalesrecibocaja" );
		promesa.success( function( data , status , headers , config ) {
			$scope.causales.causales = data._embedded.causalesrecibocaja;
			for( var i = 0; i < $scope.causales.causales.length ; i++ ){	
				$scope.causales.causales[ i ].label = 
					zeroPad ( $scope.causales.causales[ i ].codigo , 3 )
					+ " - "
					+ $scope.causales.causales[ i ].descripcion;
			}
	    });
		
		promesa.error(function(data, status, headers, config) {
	        alert("Error al obtener las causales");
		});
		
	}
	
	$scope.buscarCliente = function(){
		var cedula = $scope.cartera.cedula;
		var promesa = $http.get( "/api/clientes/search/findOneByCc?cc="+cedula );
		promesa.success( function( data , status , headers , config ) {
			$scope.cartera.razsoc = data.razsoc;
			$scope.cartera.codigo = data.codigo; 
	    });
		promesa.error(function(data, status, headers, config) {
			var prom = $http.get( "/api/clientes/search/findOneByNit?nit="+cedula );
			prom.success( function( data , status , headers , config ) {
				$scope.cartera.razsoc = data.razsoc;
				$scope.cartera.codigo = data.codigo; 
		    });
			prom.error(function(data, status, headers, config) {
		        alert("No se encontro la cédula");
			})
		});
	}
	
	
	$scope.guardar = function(){
		var dto = JSON.parse( JSON.stringify( $scope.cartera ) );
		console.log( dto );
		dto.tipo = dto.tipo.codigo;
		dto.fecha = formatearFechaISO( dto.fecha );
		var promesa = $http.post( "/api/cartera/otrosreciboscaja/" , dto );
		promesa.success( function( data , status , headers , config ) {
			alert( "Actualización completa ");
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("Error al actualizar");
		});
	}
	cargarFormulario();
});