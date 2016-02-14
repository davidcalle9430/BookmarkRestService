var pagina = 0;
var alFinal = true;
/**
 * funciòn que se encarga de cargar los datos del request ajax
 */
var cargarNombres = function(articulos) {
	alFinal = false;
	generos = articulos;
	var tabla = $("table");
	for (var i = 0; i < generos.length; i++) {
		var genero = generos[i];
		var tr = $("<tr>");
		var codigo = $("<td>", { text :genero.codigo });
		var razonSocial = $("<td>", { text : genero.razonSocial });
		var articulo = $("<td>", { text : genero.articulo });
		var referencia = $("<td>", { text : genero.referencia });
		var precio = $("<td>", { text : genero.precio });
		tr.append(codigo);
		tr.append(razonSocial);
		tr.append(articulo);
		tr.append(referencia);
		tr.append(precio);
		tabla.append(tr);
	}
	$(".loader").attr("style", "display:none");
	pagina++;
}


var clicFila = function(){
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML+"&articulo="+hijos[2].innerHTML;
}

/**
 * funciòn encarga de cargar una nueva pàgina de la tabla
 */
function agregarFila() {
	getForObject(null, "/api/articulos/search/especiales", cargarNombres);
}

var head = $("thead"); // busca los headers de la tabla
var columnas = 2; // numero de columnas de la tabla
$(document).ready(function(){
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