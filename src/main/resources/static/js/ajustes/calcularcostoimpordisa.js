/**
 * 
 */

var app = angular.module( 'calccostim' , []);
/**
 * funcion controladora de la pagina con el mismo nombre
 */
app.controller('calccostimController', function( $scope , $http ) { 
	
	
	$scope.persona = {};
	$scope.persona.textos = [];
	
	$scope.darClick = function( ){
		var A = -1.0 ,B,C,AA,D,Y = -1.0;
		if($scope.A != null && !(isNumber($scope.A))){
		   $scope.A = 0;	
		}
		if($scope.Y != null && !(isNumber($scope.Y))){
		   $scope.Y = 0;	
		}
		if($scope.A == null || $scope.A == 0){
			   $scope.A = 0;	
			   if(parseFloat($scope.Y) > 0){
				   B = parseFloat($scope.B);
				   C = parseFloat($scope.C);
				   D = parseFloat($scope.D);
				   Y = parseFloat($scope.Y);
					  	  
				  $scope.A = parseFloat(((B - C)*D + Y * C)/B);
				  A = parseFloat($scope.A);
			   } 
		}
		if($scope.Y == null || $scope.Y == 0){
			   $scope.Y = 0;	
			   if(parseFloat($scope.A)> 0){
				   B = parseFloat($scope.B);
				   C = parseFloat($scope.C);
				   D = parseFloat($scope.D);
				   A = parseFloat($scope.A);
				   $scope.Y = parseFloat((A*B-D*(B-C))/C);
				   Y = parseFloat($scope.Y);
			   } 
		}
		$scope.A = parseFloat(A).toFixed(2);
		$scope.Y = parseFloat(Y).toFixed(2);
				
	}
	
	
	$scope.cargarCodigo = function( ){
		var url = "/api/ajustes/articulo/"+$scope.codigo+"/";
		var promesa = $http.get( url );	
		promesa.success( function(data, status, headers, config) {
			$scope.nombre = data.nombre + " - " + data.referencia;
			$scope.AA = data.costprom;
			$scope.B = data.invimppas;
			$scope.C = data.ultcomp;
			if(data.ultcostproi == null){
				$scope.D = 0;
			}
			else{
				$scope.D = data.ultcostproi;
			}
				
			
	    });
		promesa.error( function(data, status, headers, config) {
	        alert("El tal artículo no existe!!!")
		});
	}
	

	
	function inicializar(){
		
		var url = "/api/textosFactura";
		var promesa = $http.get( url );	
		promesa.success( function(data, status, headers, config) {
			$scope.persona.textos = data._embedded.textosFactura;
	    });
		promesa.error( function(data, status, headers, config) {
	        alert("error")
		});
	}
	
	
	
	inicializar();
	
	
	
});