var app = angular.module( 'Compras' , []);
/**
 * funciton controladora de la pagina con el mismo nombre
 */
app.controller('ComprasController', function( $scope , $http ) { 
	
	$scope.compra = { }; //fue una mala decision usar una fachada, pero ya que
	
	$scope.compra.AA;
	$scope.compra.B;
	$scope.compra.C;
	$scope.compra.D;
	
	$scope.buscar = function(){
		var codigo = $scope.compra.codigo;
		var promesa = $http.get("/api/articulos/generocosto/"+codigo+"/");
		promesa.success(function(data, status, headers, config) {
			$scope.compra.nombre = data.nombre + " - " + data.referencia;
			$scope.compra.AA = data.costprom == null ? 0 : data.costprom;
			$scope.compra.B = data.invimppas == null ? 0 : data.invimppas;
			$scope.compra.C = data.ultcomp == null ? 0 : data.ultcomp;
			$scope.compra.D = data.ultcostpr == null ? 0 : data.ultcostpr; 
			
	    });
		promesa.error(function(data, status, headers, config) {
			$scope.compra.AA = 0;
			$scope.compra.B = 0;
			$scope.compra.C = 0;
			$scope.compra.D = 0;
	        alert("No existe el artículo");
		});
	}
	
	$scope.calcular = function(){
		if( !isNumber( $scope.compra.A ) ){
			$scope.compra.A = 0;
		}
		if( !isNumber( $scope.compra.Y ) ){
			$scope.compra.Y = 0;
		}
		if( $scope.compra.A == null || $scope.compra.A == 0 ){
			$scope.compra.A = 0;
			if( parseFloat( $scope.compra.Y ) > 0 ){
				$scope.compra.A = ( ( parseFloat( $scope.compra.B ) - parseFloat( $scope.compra.C ) ) * parseFloat( $scope.compra.D ) + parseFloat( $scope.compra.Y )  * parseFloat( $scope.compra.C ) ) / parseFloat( $scope.compra.B );
			}else{
				$scope.compra.A = 0;
			}
		}
		
		if( $scope.compra.Y == null || $scope.compra.Y == 0 ){
			$scope.compra.Y = 0;
			if( parseFloat( $scope.compra.A ) > 0 ){
				$scope.compra.Y =  ( parseFloat( $scope.compra.A ) * parseFloat( $scope.compra.B ) - parseFloat( $scope.compra.D ) * ( parseFloat( $scope.compra.B ) - parseFloat( $scope.compra.C ) )) / parseFloat( $scope.compra.C );
			}else{
				$scope.compra.Y = 0;
			}
		}
		$scope.compra.A = parseFloat( $scope.compra.A ).toFixed( 2 );
		$scope.compra.Y = parseFloat( $scope.compra.Y ).toFixed( 2 );
	}
	
});