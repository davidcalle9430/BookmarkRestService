var myApp = angular.module('opciones-usuario-eliminar', []);
myApp.controller('appController',['$scope', '$http', function($scope, $http){
	$scope.titulo = 'Eliminar Menú';
	var codigo = getUrlParameter('codigo');
	
	var promesa = $http.post( "/api/compras/ajustarcostojm/" , copia );	
 		promesa.success( function( data , status , headers , config ) {
 			alert("Registros Cargados con Éxitos")
 	    });
 		promesa.error( function( data , status , headers , config ) {
 			alert( "Ningún Registro a Cargar" );
 		});
 		console.log(promesa);
		
}]);

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};
