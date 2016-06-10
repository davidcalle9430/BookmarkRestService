var app = angular.module( 'Ajustes' , []);
/**
 * funcion controladora de la pagina con el mismo nombre
 */
app.controller('AjustesController', function( $scope , $http ) { 
	$scope.carteras = [{}];
	/**
	 * funcion que se ejecuta cuando cambia el codigo del cliente
	 */
	$scope.cambioCodigoCliente = function( cartera ){
		var TmpFact =  cartera.factura;
		// se revisa el tipo de factura
		if( cartera.tipo == 'J'){
			TmpFact = TmpFact + 100000;
		}else if( cartera.tipo == 'C' ){
			TmpFact = TmpFact + 300000;
		}
		
		var url = "/api/carteras/search/encontrarPorFacturaCodigoFecha" +
			"?codigo="+ cartera.codigo +
			"&factura="+ TmpFact +
			"&fecha="+ formatearFechaISO( cartera.fecha );
		
	
		var prom = $http.get( url );
		prom.success( function( data, status, headers, config ) {
			//Ahora hay que traer la razon social del cliente
			var promesa = $http.get( "/api/clientes/"+cartera.codigo );
			promesa.success( function( data, status, headers, config ) {
				//Ahora hay que traer la razon social del cliente
				cartera.razsoc = data.razsoc;
		    });
			promesa.error( function( data, status, headers, config ) {
		        alert("Cliente no existe " + url);
			});
	    });
		prom.error( function( data, status, headers, config ) {
	        alert("Cliente no existe " + url);
		});
	}
	/**
	 * funcion encargada de validar si el iva es valido
	 */
	$scope.validarIva = function( cartera ){
		if( !isNumber( cartera.iva ) ){
			cartera.iva = 0.0;
			return;
		}
		var promesa = $http.get( "/api/nfact/1" );
		promesa.success( function( data, status, headers, config ) {
			var iva = parseFloat( data.iva );
			if( cartera.iva  > cartera.valor * parseFloat( iva ) / 100 ){
				alert("Valor Máximo por iva es de : " + cartera.valor * parseFloat( iva ) / 100)
				cartera.iva = cartera.valor * parseFloat( iva ) / 100;
			}
	    });
		promesa.error( function( data, status, headers, config ) {
	        alert("Eror al buscar el iva en tablas " + url);
		});
	}
	/**
	 * funcion encargada de validarel causal, recibe la fila que cambió por parámetro
	 */
	$scope.validarCausal = function( cartera ){
		if( !isNumber( cartera.causal )){
			cartera.causal = 999;
		}
		var promesa = $http.get( "/api/causales/" + cartera.causal );
		promesa.success( function( data, status, headers, config ) {
			cartera.nombre = data.nombre;
	    });
		promesa.error( function( data, status, headers, config ) {
	        alert("Eror al buscar la causal en tablas " + url);
		});
	}
	
	/**
	 * funcion que valida si es la ultima fila con el fin de saber si es encesario agregar o no
	 * una nueva fila
	 */
	function esUltimo( cartera , ultimo ){
		return cartera.factura == ultimo.factura;
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
		var enviar = [];
		for( var i = 0 ; i < $scope.carteras.length ; i++ ){
			var nvoObj = JSON.parse( JSON.stringify( $scope.carteras[ i ] ) );
			nvoObj.fecha = formatearFechaISO( nvoObj.fecha );
			enviar.push( nvoObj ); //se cambia el objeto para que tenga formato iso , la fecha
		}
		console.log( enviar );
		var promesa = $http.post( "/api/ajustes/notasdecartera" , enviar );
		promesa.success( function( data, status, headers, config ) {
			alert("Registros cargados con Éxito")
	    });
		promesa.error( function( data, status, headers, config ) {
		});
	}
});