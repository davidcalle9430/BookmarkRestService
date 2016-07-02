/**
 * funcion controladroa de la pantall con el mismo nombre
 */
$( document ).ready( function( ){
	
	function errorGeneros( ){
		alert( "Error al cargar los articulos ");
	}
	
	function inicializarGeneros( generos ){
		var generosOption = $( "#generos" );
		for( var i = 0 ; i < generos.length ; i++ ){
			var genero = generos[ i ];
			var option = $( "<option>" , 
					{ text : zeroPad( genero.codigo , 6 ) + " " + genero.nombre , value : genero.codigo });
			generosOption.append( option );
		}
		
	}
	
	function cargarGeneros( ){
		getForObject( null , "/api/articulos/search/articulosgeneros" 
				, inicializarGeneros , errorGeneros );
	}
	
	cargarGeneros();
});
