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
		var nombre = $("<td>", { text : genero.nombre });
		var cantDisp = $("<td>", { text : genero.cantdisp });
		tr.append(codigo);
		tr.append(nombre);
		tr.append(cantDisp);
		tabla.append(tr);
	}
	pagina++;
}


var clicFila = function(){
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML;
}

/**
 * Función encargada de crear los encabezados de las tablas
 */
function crearEncabezados() {
	// codigo nombre ingles, nombre español, tipo, con iva
	var tabla = $("#articulos").first();
	var tr = $("<tr>");
	var thCodigo = $("<th>", { text : "Código"});
	var thNombre = $("<th>", { text : "Nombre "});
	var thCantDisp = $("<th>", {text : "Cant. Disp."});
	tr.append(thCodigo);
	tr.append(thNombre);
	tr.append(thCantDisp);
	tabla.append(tr);
}


/**
 * funciòn encarga de cargar una nueva pàgina de la tabla
 */
function agregarFila() {
	getForObject({page : pagina}, "/api/generos", cargarNombres);
}
$(document).ready(function(){
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
})