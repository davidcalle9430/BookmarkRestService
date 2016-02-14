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
		var nombre = $("<td>", { text : genero.nombre });
		var cantDisp = $("<td>", { text : genero.cantdisp });
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
 * Función encargada de crear los encabezados de la tabla.
 */
function crearEncabezados() {
	// codigo nombre ingles, nombre español, tipo, con iva
	var tabla = $("#articulos").first();
	var tr = $("<thead>");
	var thCodigo = $("<th>", { text : "Código"});
	var thNombre = $("<th>", { text : "Nombre "});
	var thCantDisp = $("<th>", {text : "Cant. Disp."});
	tr.append(thCodigo);
	tr.append(thNombre);
	tr.append(thCantDisp);
	
	tabla.append(tr);
	head = $("thead");
}


/**
 * Función encargdaa de cargar una nueva página de ariculos en la tabla.
 */
function agregarFila() {
	getForObject({page : pagina}, "/api/generos", cargarNombres);
}
var head = $("thead"); // busca los headers de la tabla
var columnas = 3; // numero de columnas de la tabla
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
		
		if(head.position().top -$(this).scrollTop() < 0 ){
			head.css("position", "fixed");
			head.css("top", "0px");
			head.css("left", "0px");
			head.find("th").each(function(el){
				$(this).css("width", 100 / columnas + "vw")
			})
		}else{
			head.css("position", "");
			head.css("top", "");
			head.css("left", "");
		}
	});
	$("table").on("click","tr", clicFila);
})