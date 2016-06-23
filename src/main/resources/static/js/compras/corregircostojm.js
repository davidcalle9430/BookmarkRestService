var app = angular.module( 'Compras' , []);
/**
 * funciton controladora de la pagina con el mismo nombre
 */
app.controller('ComprasController', function($scope,$http) { 
	
	$scope.compras = {};
	$scope.compras.lista = [ { } ];
	
	$scope.cargar = function( compra ){
		var codigoFormateado = compra.codigo;
		compra.codigo = formatearCodigo( codigoFormateado );
		var codigoReal = obtenerCodigoReal( compra.codigo );
		var chequeo = darCodigoFormateado( codigoReal );
		
		if( chequeo != compra.codigo ) {
			alert("No Corresponde el digito de chequeo");
			return;
		}

		var promesa = $http.get( "/api/articulos/generocosto/" + codigoReal + "/" );
		
		promesa.success( function( data , status , headers , config ) {
			compra.referencia = data.referencia;
			compra.nombre = data.nombre;
			console.log( data );
			if( data.cosultcom == null ){
				compra.cosultcom = 0;
			}else{
				compra.cosultcom = data.cosultcom;
			}
			
	    });
		promesa.error( function( data , status , headers , config ) {
			alert( "Artículo no Existe" );
		});
	}
	
	/**
	 * funcion que valida si es la ultima fila con el fin de saber si es encesario agregar o no
	 * una nueva fila
	 */
	function esUltimo( cartera , ultimo ){
		return cartera.codigo == ultimo.codigo;
	}
	/**
	 * funcion  que agrega una nueva fila
	 */
	$scope.agregarFila = function( $event , producto ){
		if( esUltimo( producto , $scope.compras.lista[ $scope.compras.lista.length - 1 ] ) ){
			if( $event.keyCode == 9 ){ // OPRIME TAB
				$scope.compras.lista.push( { } ); // se incializa una fila vacia
			}
		}
	}
	
	
	$scope.incorporar = function( ){
		
		var copia = JSON.parse( JSON.stringify( $scope.compras.lista ) );
		
		for( var i = 0 ; i < copia.length ; i++ ){
			copia[ i ].codigo = obtenerCodigoReal( copia[ i ].codigo );
		}
		
		var promesa = $http.post( "/api/compras/ajustarcostojm/" , copia );
		
		promesa.success( function( data , status , headers , config ) {
			alert("Registros Cargados con Éxitos")
	    });
		promesa.error( function( data , status , headers , config ) {
			alert( "Ningún Registro a Cargar" );
		});
		
		
	}
});