var app = angular.module( 'clientesEspeciales' , []);
/**
 * funciton controladora de la pagina con el mismo nombre
 */
app.controller('ClientesEspecialesController', function($scope,$http) { 
	$scope.cliente = {}; $scope.cliente.codigo = ""; $scope.cliente.productos = []
	$scope.buscar = function(){
		var promesa = $http.get("/api/especia/search/findByCodigo?codigo="+$scope.cliente.codigo+"&projection=cliente");
		promesa.success(function(data, status, headers, config) {
			if(data._embedded.especias.length == 0 ){ alert("No es un cliente especial");}
			$scope.cliente.productos = data._embedded.especias;
			$scope.cliente.nombre = data._embedded.especias[ 0 ].clientes.razsoc;
			for( var i = 0 ; i < $scope.cliente.productos.length ; i++  ){
				$scope.cliente.productos[ i ].nuevoNombre = $scope.cliente.productos[ i ].referencia;
				$scope.cliente.productos[ i ].chequeo = darCodigoFormateado( $scope.cliente.productos[ i ].articulo );
			}
	    });
		promesa.error(function(data, status, headers, config) {
	        alert("Error al cargar!");
		});
	}
	
	function esUltimo( producto , ultimo ){
		return producto.codigo == ultimo.codigo && producto.articulo == ultimo.articulo;
	}
	
	$scope.agregarFila = function( $event , producto ){
		if( esUltimo( producto , $scope.cliente.productos[ $scope.cliente.productos.length - 1 ] ) ){
			console.log( $event.keyCode );
			if( $event.keyCode == 9 ){ // OPRIME TAB
				$scope.cliente.productos.push( { nuevo : true , clientes : {}} ); // se incializa un producto vacio
			}
		}
	}
	$scope.actualizar = function(){
		var aEnviar = []
		for( var i = 0 ; i < $scope.cliente.productos.length ; i++  ){
			var nuevo = {};
			nuevo.codigo = $scope.cliente.codigo;
			nuevo.articulo = $scope.cliente.productos[ i ].articulo;
			nuevo.referencia = $scope.cliente.productos[ i ].nuevoNombre;
			nuevo.precio = $scope.cliente.productos[ i ].precio;
			aEnviar.push( nuevo );
		}
		var url = "/api/especial/lista";
		var promesa = $http.post( url , aEnviar );
		promesa.success( function(data, status, headers, config) {
			alert("Actualización correcta");
	    });
		promesa.error( function(data, status, headers, config) {
	        alert("Error al actualizar");
		});
	}
	$scope.actualizarFila = function( producto ){
		var chequeo = producto.chequeo;
		var codigo = obtenerCodigoReal( producto.chequeo );
		var revision = darCodigoFormateado( codigo );
		if( chequeo != revision ){
			alert("El dígito de verificación no es correcto");
			return;
		}
		//falta verificar que el codigo haya quedado bien escrito
		var promesa = $http.get("/api/articulos/search/findOneBycodigo?codigo="+codigo);
		promesa.success( function(data, status, headers, config) {
			producto.articulo = data.codigo;
			producto.referencia = data.referencia;
			producto.precio = data.precio;
			producto.nuevoNombre = data.referencia;
			//aca es buena idea verificar si ya no exite ese producto
			console.log("Segundo llamado a  " + "/api/especia/search/findByCodigo?codigo="+data.codigo+"&projection=cliente" )
			var promise = $http.get("/api/especia/search/findOneByCodigoAndArticulo?codigo="+$scope.cliente.codigo+"&articulo="+data.codigo);
			promise.success( function(data, status, headers, config) {
				alert("Ya existe esta una referencia especial");
			});
		} );
		promesa.error(function(data, status, headers, config) {
	        alert("No se encotró el artículo");
		});
	}
});