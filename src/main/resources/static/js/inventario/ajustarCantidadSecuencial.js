var pagina = 0;
var alFinal = true;

/**
 * Se encarga de cargar los datos de cada artículo del request ajax en una tabla HTML.
 * @paramas articulos: Los articulos a cargar.
 * 
 */
var cargarNombres = function(articulos) {
	alFinal = false;
	generos = articulos._embedded.generos;
	var tabla = $("#articulos").first();
	for (var i = 0; i < generos.length; i++) {
		var genero = generos[i];
		var tr = $("<tr>");
		var codigo = $("<td>", {text :genero.codigo});
		codigo.css("width",'33.3%');
		var nombre = $("<td>", { text : genero.nombre });
		nombre.css("width",'33.3%');
		var cantDisp = $("<td>", { text : genero.cantdisp });
		cantDisp.css("width",'33.3%');
		tr.append(codigo);
		tr.append(nombre);
		tr.append(cantDisp);
		tabla.append(tr);
	}
	pagina++;
}

/**
 * Se encarga de redirigir a la vista para editar el Artículo seleccionado.
 */
var clicFila = function(){
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML;
}

/**
 * Función encargada de cargar una nueva página de ariculos en la tabla.
 */
function agregarFila() {
	getForObject( { size : 9999999 } , "/api/generos", cargarNombres);
}
var head = $("thead"); // busca los headers de la tabla
var columnas = 3; // numero de columnas de la tabla
$(document).ready(function(){

	agregarFila();
	
	$( "table" ).on( "click" , "tr" , clicFila );
})