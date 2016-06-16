var app = angular.module( 'Facturacion' , []);
var Jmq = true; // como esta opcion solo aparce ene l menú JM, jmq siempre es verdadero
// si tan solo el anterior desarrollador tuviera algo de orden o documentación
/**
 * funcion controladora de la pagina con el mismo nombre
 */
app.controller('FacturacionController', function($scope,$http) { 
	$scope.viewHolder = {};
	
	$scope.validarFactura = function(){
		if($scope.viewHolder.numFactura == null || $scope.viewHolder.numFactura == ""){
			alert("Debe digitar el número de la factura")
		}
	}
	
	$scope.validarFecha = function(){
		if($scope.viewHolder.fecha == null || $scope.viewHolder.fecha == ""){
			alert("Debe digitar una fecha válida");
			$scope.viewHolder.fecha = formatearFecha( darFechaActual( ) );
		}
	}
	
	$scope.cambioCliente = function(){
		//lo primero es buscar ese codigo dentro de los clientes valdios
		var codigo = $scope.viewHolder.codigoCliente;
		var promesa = $http.get( "/api/clientes/" + codigo );
		promesa.success( function( data, status, headers, config ) {
			$scope.viewHolder.razsoc = data.razsoc;
		} );
		promesa.error( function( data, status, headers, config ) {
	        alert("No se encotró el Cliente");
		});
		// como siempre es JMQ, se imite todo lo relacionado a JMQ = False
		var tmpFact = $scope.viewHolder.numFactura + 100000;
		
		var promesa = $http.get( "/api/carteras/search/encontrarPorFacturaCodigoFecha?"
				+"factura=" + tmpFact + "&" 
				+"codigo=" + codigo + "&"
				+"fecha=" + formatearFechaISO( $scope.viewHolder.fecha ) );
		
		promesa.success( function(data, status, headers, config ) {
			// no se hace anda con los datos, la idea solo es verificar que exista
			
		} );
		promesa.error( function( data, status, headers, config ) {
	        alert("Factura ya registrada o anulada");
	        window.location.href = "/jm/";
		});
		
		
		
	}
	
});