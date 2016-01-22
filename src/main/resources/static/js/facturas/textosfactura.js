/**
 *  función ajax que carga los elementos de la tabla
 */
var pagina = 0;
var alFinal = false;
function ajaxCall() {
	$.ajax({
		url : '/api/textosFactura?page=' + pagina,
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

function crearFila(textos) {
	textos = textos._embedded.textosFactura;
	for (var i = 0; i < textos.length; i++) {
		var tr = $("<tr>");
		var columnaCodigo = $('<td>', {
			text : textos[i].codigo
		});
		var columnaTexto1 = $('<td>', {
			text : textos[i].texto1
		});
		var columnaTexto2 = $('<td>', {
			text : textos[i].texto2
		});
		var columnaTexto3 = $('<td>', {
			text : textos[i].texto3
		});
		
		tr.append(columnaCodigo);
		tr.append(columnaTexto1);
		tr.append(columnaTexto2);
		tr.append(columnaTexto3);
		$('tbody').append(tr);
	}
}
function clicFila(){
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML;
}

var head = $("thead"); // busca los headers de la tabla
var columnas = 4; // numero de columnas de la tabla
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