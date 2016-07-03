

var app = angular.module( 'CostoVentas' , []);
/**
 * funcion controladora de la pagina con el mismo nombre
 */
app.controller('CostoVentasController', function( $scope , $http ) {
	
	$scope.esconderCodigo = true;
	$scope.esconderRango = true;
	$scope.esconderConsulta = true;
	$scope.form = {}; //esto es para no perder la refeencia en memoria al buscar las lineas
	$scope.form.lineas = [];
	
	
	$scope.validarDesde = function(	 ){
		var reg = /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g;
		if(! $scope.form.desde.match( 
				reg ) ){
			alert(" formato inválido ")
			$scope.form.desde = "";
		}
	}
	
	$scope.validarHasta = function( ){
		var reg = /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/g;
		if(! $scope.form.hasta.match( 
				reg ) ){
			alert(" formato inválido ")
			$scope.form.hasta = "";
		}
	}
	
	$scope.hablitarRangos = function( ){
		if( $scope.rangos ){
			$scope.esconderRango = false;
			$scope.codigosVarios = false;
			$scope.esconderCodigo = true;
		}else{
			$scope.esconderRango = true;
		}
		
	}
	
	$scope.validarNumero = function( num ){
		if( !isNumber( num ) ){
			alert("Debe Ingresar un numero");
			num = "";
		}
	}
	
	$scope.habilitarCodigo = function( ){
		if( $scope.codigosVarios ){
			$scope.esconderCodigo = false;
			$scope.rangos = false;
			$scope.esconderRango = true;
		}else{
			$scope.esconderCodigo = true;
		}
	}
	
	$scope.consultar = function( ){
		$scope.esconderConsulta = false;
	}
	
	
	function cargarLineas( ){
		var promesa = $http.get( "/api/lineas" );
		promesa.success( function( data , status , headers , config ) {
			data = data._embedded.lineas;
			$scope.form.lineas = data;
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("Error al actualizar");
		});
	}
	
	
	
	$scope.formatearLinea = function( linea ){
		var num = zeroPad( linea.linea , 2 );
		return num + " " + linea.rango1 + " " + linea.rango2;
	}
	
	
	cargarLineas();
});