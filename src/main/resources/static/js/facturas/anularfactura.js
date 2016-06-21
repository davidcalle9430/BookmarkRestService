var app = angular.module( 'Facturacion' , []);
var Jmq = false ; // como esta opcion solo aparce en el menu impordisa
// si tan solo el anterior desarrollador tuviera algo de orden o documentación
/**
 * funcion controladora de la pagina con el mismo nombre
 */
app.controller('FacturacionController', function($scope,$http) { 
	$scope.viewHolder = {};//esta varibale view holder funciona como la fachada que se muesra a la vista
	$scope.viewHolder.productos = [];
	
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
		// como no es JMQ, se omite todo lo relacionado a JMQ = true
		var tmpFact = $scope.viewHolder.numFactura;
		
		var promesa = $http.get( "/api/cartera/encontrarPorCodigoFechaFactura/?"
				+"factura=" + tmpFact + "&" 
				+"codigo=" + codigo + "&"
				+"fecha=" + formatearFechaISO( $scope.viewHolder.fecha ) );
		
		promesa.success( function(data, status, headers, config ) {
			// no se hace anda con los datos, la idea solo es verificar que exista
			//ahora se hace el segundo query al coontrolador rest de cartera
			var prod = $http.get( "/api/cartera/articulosFactura/?"
					+"ndoc=" + tmpFact + "&" 
					+"fecha=" + formatearFechaISO( $scope.viewHolder.fecha ) );	
			prod.success( function(data, status, headers, config ) {
				$scope.viewHolder.productos = data;
				for( var i = 0 ; i < data.length ; i++ ){
					$scope.viewHolder.productos[ i ].codFormateado 
						=  darCodigoFormateado( data[ i ].codigo );
				}
			});
			
			prod.error( function( data, status, headers, config ) {
		        alert("Ningún articulo facturado con la factura");
			});
			
		} );
		promesa.error( function( data, status, headers, config ) {
	        alert("Factura ya registrada o anulada");
	        //window.location.href = "/jm/";
		});
	}
	
	$scope.anular = function(){
		if ( !confirm('Seguro que desea eliminar la factura') ) {
		    return;
		} else {
		    var facturaPk = {};
		    facturaPk.factura = $scope.viewHolder.numFactura;
		    facturaPk.codigo = $scope.viewHolder.codigoCliente;
		    facturaPk.fecha = $scope.viewHolder.fecha;
		    var promesa = $http.post( "/api/factura/anular/" , facturaPk );
			promesa.success( function( data, status, headers, config ) {
				alert("Factura anulada");
			} );
			promesa.error( function( data, status, headers, config ) {
		        alert("Error al anular la factura");
			});
		}
		
	}
	
});