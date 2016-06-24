/**
 * 
 */
function ajaxCall() {
	$.ajax({
		url : '/api/corrers?sort=codigo&size=999999',
		success : function(data) {
			crearFila( data );
			alFinal = false;
			pagina++;
		},
		error : function(data) {
			console.log("Error al recuperar los datos");
		}
	})
}

function crearFila(corrers) {
	corrers = corrers._embedded.corrers;
	for (var i = 0; i < corrers.length; i++) {
		var tr = $("<tr>");
		var columnaCodigo = $('<td>', {
			text : corrers[i].codigo
		});
		var columnaNombre = $('<td>', {
			text : corrers[i].nombre
		});
		var columnaIva = $('<td>', {
			text : corrers[i].iva ? "Sí" : "No"
		});
		tr.append(columnaCodigo);
		tr.append(columnaNombre);
		tr.append(columnaIva);
		$('tbody').append(tr);
	}
}
function clicFila(){
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML;
}

var head = $("thead"); // busca los headers de la tabla

$(document).ready(function() {
	
			ajaxCall( );
			
			$( "table" ).on( "click" , "tr" , clicFila );
});