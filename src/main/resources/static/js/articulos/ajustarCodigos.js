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
	var tr = $("<thead>");
	var thCodigo = $("<th>", { text : "Código"});
	thCodigo.css("width","18vw");
	var thNombreIngles = $("<th>", { text : "Nombre Inglés"});
	thCodigo.css("width","18vw");
	var thNombreEspaniol = $("<th>", {text : "Nombre Español"});
	thCodigo.css("width","18vw");
	var thTipo = $("<th>", {text : "Tipo"});
	thCodigo.css("width","18vw");
	var thIva = $("<th>", {text : "Iva"});
	thCodigo.css("width","18vw");
	tr.append(thCodigo);
	tr.append(thNombreEspaniol);
	tr.append(thNombreIngles);
	tr.append(thTipo);
	tr.append(thIva);
	tabla.append(tr);
	head = $("thead");
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
var head = $("thead"); // busca los headers de la tabla
var columnas = 5; // numero de columnas de la tabla
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
		if(head.position().top -$(this).scrollTop() < 0 ){
			head.css("position", "fixed");
			head.css("top", "0px");
			head.css("width", "90vw");
			head.find("th").each(function(el){
				$(this).css("width", 90 / columnas + "vw");
			});
			$('table').find("td").each(function(el){
				$(this).css("width", 90 / columnas + "vw");
			});
		}else{
			head.css("position", "");
		}
	});
	$("table").on("click","tr", clicFila);
});