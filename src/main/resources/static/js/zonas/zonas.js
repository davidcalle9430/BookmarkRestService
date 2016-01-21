/**
 * 
 */
var pagina = 0;
var alFinal = false;
function ajaxCall() {
	$.ajax({
		url : '/api/zonas?page=' + pagina,
		success : function(data) {
			crearFila(data);
			alFinal = false;
			pagina++;
		},
		error : function(data) {
			console.log("Error al recuperar los datos");
		}
	})
}

function crearFila(zonas) {
	zonas = zonas._embedded.zonas;
	for (var i = 0; i < zonas.length; i++) {
		var tr = $("<tr>");
		var columnaZona = $('<td>', {
			text : zonas[i].zona
		});
		var columnaNombre = $('<td>', {
			text : zonas[i].nombre
		});
		tr.append(columnaZona);
		tr.append(columnaNombre);
		$('tbody').append(tr);
	}
}
function clicFila(){
	var hijos = $(this).children();
	window.location = "editar/?zona="+hijos[0].innerHTML;
}

var head = $("thead"); // busca los headers de la tabla
var columnas = 2; // numero de columnas de la tabla
$(document).ready(function() {
			ajaxCall();
			$(window).scroll(function() {
						if ($(window).scrollTop() + $(window).height() > $(document).height() - 50) {
							if (!alFinal) {
								alFinal = true;
								ajaxCall();
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
});