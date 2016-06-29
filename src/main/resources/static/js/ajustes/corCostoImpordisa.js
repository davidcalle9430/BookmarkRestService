var app = angular.module( 'corccostim' , []);
/**
 * funciton controladora de la pagina con el mismo nombre
 */

app.controller('corccostimController', function($scope,$http) { 
	
	$scope.vista = {};
	$scope.vista.lista = [{}];
	
	$scope.actualizar = function(fila){
		var formateado = "";
		var codigoreal = "";
	
		formateado = formatearCodigo(fila.codigoFormateado);
		fila.codigoFormateado = formateado;
		codigoreal = obtenerCodigoReal(fila.codigoFormateado);
		fila.codigo = codigoreal;
		if(!verificarCheckSum(fila.codigoFormateado)){
			fila.codigoFormateado = "";
			alert("El código de verificación no corresponde, intentelo de nuevo");
			return;
		}
		//Primera Consulta
		var promesa = $http.get( "/api/articulos/"+codigoreal+"/" );
		promesa.success( function(data, status, headers, config) {
			fila.referencia = data.referencia;
			if(data.costjm == null){
				fila.consultcon = 0;
			}
			else{
				fila.consultcon = data.costjm;
			}
			var promise = $http.get( "/api/generos/"+Math.floor(codigoreal/1000)+"/" );
			//Segunda Consulta
			promise.success( function(data, status, headers, config) {
				fila.nombre = data.nombre;
				console.log(fila);
			});
			promise.error( function(data, status, headers, config) {
				alert("El artículo no posee un nombre");
			});
			
				
	    });
		
		promesa.error( function(data, status, headers, config) {
		        alert("El artículo no existe");
		});
	}
	
	
	$scope.agregarFila = function ($event){	
		if($event.keyCode == 9){
			$scope.vista.lista.push({});
		}
	}
	
	$scope.clickCargar = function (){	
		var promise = $http.post("/api/ajustes/corCostoImpordisa/" , $scope.vista.lista);
		promise.success( function(data, status, headers, config) {
			alert("Articulo(s) cargado(s) satisfactoriamente");
		});
		promise.error( function(data, status, headers, config) {
			alert("El artículo no posee un nombre");
		});
		
	}
	
	
	
	
});
