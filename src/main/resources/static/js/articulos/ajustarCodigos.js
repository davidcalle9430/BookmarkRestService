/**
 * funciòn que se encarga de cargar los datos del request ajax
 */
var cargarNombres = function(articulos) {
	alFinal = false;
	generos = articulos._embedded.generos;
	var tabla = $("#articulos").first();
	for (var i = 0; i < generos.length; i++) {
		var genero = generos[i];
		var tr = $("<tr>");
		var codigo = $("<td>", {text : genero.codigo});
		var nombreIngles = $("<td>", { text : genero.nombrei });
		var nombreEspaniol = $("<td>", { text : genero.nombre });
		var tipo = $("<td>", { text : genero.tipart });
		var iva = $("<td>", { text : genero.iva });
		tr.append(codigo);
		tr.append(nombreEspaniol);
		tr.append(nombreIngles);
		tr.append(tipo);
		tr.append(iva);
		tabla.append(tr);
	}
	pagina++;
}
/**
 * funciòn encarga de cargar una nueva pàgina de la tabla
 */
function agregarFila() {
	getForObject( { size : 99999 }, "/api/generos", cargarNombres);
}

/**
 * función encargadad de manejar el click de cada una de las filas
 */
var clicFila = function(){
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML;
}

var head = $("thead"); // busca los headers de la tabla

$(document).ready(function() {
	
	agregarFila( );
	
	$("table").on( "click" , "tr" , clicFila );
	
});