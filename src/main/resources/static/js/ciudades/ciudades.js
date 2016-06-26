/**
 * 
 */
var pagina = 0;
var alFinal = false;
function ajaxCall() {
	$.ajax({
		url : '/api/ciudades?sort=codigo&size=9999999',
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

function crearFila(ciudades) {
	ciudades = ciudades._embedded.ciudades;
	for (var i = 0; i < ciudades.length; i++) {
		var tr = $("<tr>");
		var columnaZona = $('<td>', {
			text : ciudades[i].codigo
		});
		var columnaNombre = $('<td>', {
			text : ciudades	[i].ciudad
		});
		tr.append(columnaZona);
		tr.append(columnaNombre);
		$('tbody').append(tr);
	}
}
function clicFila(){
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML;
}

var head = $("thead"); // busca los headers de la tabla
var columnas = 2; // numero de columnas de la tabla

$(document).ready(function() {
			
			ajaxCall();
			
			$("table").on("click","tr", clicFila);
});

