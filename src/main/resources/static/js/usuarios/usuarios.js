/**
 * 
 */
var pagina = 0;
var alFinal = false;
/**
 * funcíon que trae la lista de usuarios asíncronamente
 */
function ajaxCall() {
	$.ajax({
		url : '/api/usuariosnivel/',
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

function crearFila(usuarios) {
	for (var i = 0; i < usuarios.length; i++) {
		var tr = $("<tr>");
		var columnaUsuario = $('<td>', {
			text : usuarios[i].usuario
		});
		var columnaNivel = $('<td>', {
			text : usuarios[i].nivel
		});
		var columnaNombreNivel = $('<td>', {
			text : usuarios[i].nombreNivel
		});
		var columnaMaxDias = $('<td>', {
			text : usuarios[i].maxDias
		});
		var columnaDiasAlerta = $('<td>', {
			text : usuarios[i].diasAlerta
		});
		tr.append(columnaUsuario);
		tr.append(columnaNivel);
		tr.append(columnaNombreNivel);
		tr.append(columnaMaxDias);
		tr.append(columnaDiasAlerta);
		$('tbody').append(tr);
	}
}
function clicFila(){
	var hijos = $(this).children();
	window.location = "editar/?usuario="+hijos[0].innerHTML;
}

var head = $("thead"); // busca los headers de la tabla
var columnas = 5; // numero de columnas de la tabla
$(document).ready(function() {
			ajaxCall();
			$(window).scroll(function() {
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