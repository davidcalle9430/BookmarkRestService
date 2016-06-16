var app = angular.module( 'Facturacion' , []);
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
		var codigoCliente = $scope.viewHolder.codigoCliente;
	}
	
});