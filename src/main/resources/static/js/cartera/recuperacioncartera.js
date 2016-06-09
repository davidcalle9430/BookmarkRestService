var app = angular.module( 'Cartera' , []);
/**
 * funciton controladora de la pagina con el mismo nombre
 */
app.controller('CarteraController', function($scope,$http) { 
	$scope.cartera = {};
	var TmpFact = null;
	$scope.validarTipo = function(){
		alert("Entra")
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
				"?codigo="+$scope.cartera.cliente+
				"&factura="+$scope.cartera.numero+
				"&fecha="+formatearFechaISO( $scope.cartera.fecha );
			var prom = $http.get( url );
			prom.success(function(data, status, headers, config) {
				alert(JSON.stringify( data ));
				
		    });
			prom.error(function(data, status, headers, config) {
		        alert("Cliente no existe " + url);
			});
			
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("Cliente no existe");
		});
	}
	
	$scope.obtenerFactura = function(){
		if( $scope.cartera.tipo == 'J'){
			TmpFact = parseInt( $scope.cartera.factura )+ 100000
		}else if( $scope.cartera.tipo == 'J' ){
			TmpFact = parseInt( $scope.cartera.factura )+ 300000
		}else{
			
		}
	}
});