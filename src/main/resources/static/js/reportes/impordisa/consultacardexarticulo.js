/**
 * funcion controladroa de la pantall con el mismo nombre
 */
$( document ).ready( function( ){
	
	function errorGeneros( ){
		alert( "Error al cargar los generos ");
	}
	
	function inicializarGeneros( generos ){
		generos = generos._embedded.generos;
		var generosOption = $( "#generos" );
		for( var i = 0 ; i < generos.length ; i++ ){
			var genero = generos[ i ];
			var option = $("<option>" , { text : zeroPad( genero.codigo , 3 ) + " " + genero.nombre , value : genero.codigo });
			generosOption.append( option );
		}
		
	}
	
	function cargarGeneros( ){
		getForObject( { size : 99999 } , "/api/generos" , inicializarGeneros , errorGeneros );
	}
	
	cargarGeneros();
});
