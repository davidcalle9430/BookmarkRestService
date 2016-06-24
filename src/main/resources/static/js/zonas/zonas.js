/**
 * 
 */
var pagina = 0;
var alFinal = false;
function ajaxCall() {
	$.ajax({
		url : '/api/zonas?size=999999&page=' + pagina,
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
		
		$( 'tbody' ).append( tr );
	}
}
function clicFila(){
	var hijos = $(this).children();
	window.location = "editar/?zona="
		+ hijos[ 0 ].innerHTML;
}

var head = $("thead"); // busca los headers de la tabla
var columnas = 2; // numero de columnas de la tabla
$(document).ready(function() {
	
			ajaxCall();
			
			$( "table" ).on( "click" , "tr" , clicFila );
});