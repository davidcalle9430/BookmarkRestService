var pagina = 0;
var alFinal = true;
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
 * Función encargada de crear los encabezados de las tablas
 */
function crearEncabezados() {
	// codigo nombre ingles, nombre español, tipo, con iva
	var tabla = $("#articulos").first();
	var tr = $("<tr>");
	var thCodigo = $("<th>", { text : "Código"});
	var thNombreIngles = $("<th>", { text : "Nombre Inglés"});
	var thNombreEspaniol = $("<th>", {text : "Nombre Español"});
	var thTipo = $("<th>", {text : "Tipo"});
	var thIva = $("<th>", {text : "Iva"});
	tr.append(thCodigo);
	tr.append(thNombreEspaniol);
	tr.append(thNombreIngles);
	tr.append(thTipo);
	tr.append(thIva);
	tabla.append(tr);
}
/**
 * funciòn encarga de cargar una nueva pàgina de la tabla
 */
function agregarFila() {
	getForObject({page : pagina}, "/api/generos", cargarNombres);
}

/**
 * función encargadad de manejar el click de cada una de las filas
 */
var clicFila = function(){
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML;
}

$(document).ready(function() {
	crearEncabezados();
	agregarFila();
	$(window).scroll(function() {
		if ($(window).scrollTop() + $(window).height() > $(document).height() - 50) {
			if (!alFinal) {
				alFinal = true;
				agregarFila();
			}
		}
	});
	$("table").on("click","tr", clicFila);
});