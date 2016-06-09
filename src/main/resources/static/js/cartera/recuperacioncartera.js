var app = angular.module( 'Cartera' , []);
var TmpFact = null;
/**
 * funciton controladora de la pagina con el mismo nombre
 */
app.controller('CarteraController', function($scope,$http) { 
	//inicializacion de variables
	$scope.cartera = {};
	$scope.mCartera = null;
	
	$scope.esconderTextArea = true;
	$scope.escoderFormPago = true;
	$scope.cartera.cant = 0;
	$scope.cartera.cantdeb = 0;
	$scope.cartera.cantcre = 0;
	
	
	$scope.validarTipo = function(){
		if( $scope.cartera.tipo != 'I' && $scope.cartera.tipo == 'J' && $scope.cartera.tipo == 'C'){
			alert("Tipo Inválido");
		}
	}
	
	$scope.obtenerCliente = function (){
		var promesa = $http.get("/api/clientes/"+$scope.cartera.cliente);
		promesa.success(function(data, status, headers, config) {
			$scope.cartera.razsoc = data.razsoc;
			// ahora haty qyue obtener la carte que cumpla con esos requisitos
			
			var url = "/api/carteras/search/encontrarPorFacturaCodigoFecha" +
				"?codigo="+ $scope.cartera.cliente +
				"&factura="+ TmpFact +
				"&fecha="+ formatearFechaISO( $scope.cartera.fecha );
			var prom = $http.get( url );
			prom.success( function( data, status, headers, config ) {
				$scope.mCartera = data;
				$scope.cartera.saldo = data.saldo;
				$scope.cartera.notad = data.notad;
				$scope.cartera.notac = data.notac;
				$scope.cartera.fechapago = data.fechapago;
				$scope.cartera.observac = data.observac;
				$scope.escoderFormPago = false;
		    });
			prom.error( function( data, status, headers, config ) {
		        alert("Cliente no existe " + url);
			});
			
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("Cliente no existe");
		});
	}
	
	$scope.obtenerFactura = function(){
		if( $scope.cartera.tipo == 'J' ){
			TmpFact = parseInt( $scope.cartera.numero )+ 100000
		}else if( $scope.cartera.tipo == 'C' ){
			TmpFact = parseInt( $scope.cartera.numero )+ 300000
		}else{
			TmpFact = $scope.cartera.numero;
		}
	}
	
	$scope.validarPagado = function(){
		var pagado = $scope.cartera.cant;
		if( isNumber( pagado ) ){
			//no lo pondre como dinero, se cambia la fecha por la fecha actual
			$scope.cartera.fechapago =formatearFecha( darFechaActual() )
			var valor = parseInt( pagado );
			if( valor < 0 ){
				$scope.cartera.fechapago = "  /  /    "
			}
		}else{
			alert("Debe registrar algún valor de pago")
		} 
	}
	
	$scope.pagarCredito = function(){
		$scope.esconderTextArea = false;
	}
	
	$scope.guardar = function(){
		$scope.escoderFormPago = true;
		$scope.esconderTextArea = true;
		$scope.mCartera.saldo = $scope.mCartera.saldo - $scope.cartera.cant;
		$scope.mCartera.notad = $scope.mCartera.notad - $scope.cartera.cantcre;
		$scope.mCartera.notac = $scope.mCartera.notac - $scope.cartera.cantdeb;
		$scope.mCartera.observac = $scope.cartera.observac;
		console.log( $scope.mCartera  );
		var promesa = $http.post( "/api/cartera/reccartera/", $scope.mCartera );
		promesa.success( function( data , status , headers , config ) {
			alert("Actualización Correcta")
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("Error al actualizar");
		});
	}
});