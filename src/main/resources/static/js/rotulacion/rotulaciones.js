/**
 * funcion controladora de eventos de la patnalla con el mismo nombre
 */

function ajaxCall() {
	$.ajax({
		url : '/api/clientes?projection=rotulacion&size=9999999',
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

function crearFila(clientes) {
	clientes = clientes._embedded.clientes;
	for (var i = 0; i < clientes.length; i++) {
		
		var tr = $("<tr>");
		
		var columnaCodigo = $('<td>', {
			text : clientes[i].codigo
		});
		var columnaRazonSocial = $('<td>', {
			text : clientes[i].razsoc
		});
		var columnaCiudad = $('<td>', {
			text : clientes[i].ciudad.ciudad
		});
		var columnaRotulo = $('<td>', {
			text : clientes[i].rotulo
		});
		
		tr.append(columnaCodigo);
		tr.append(columnaRazonSocial);
		tr.append(columnaCiudad);
		tr.append(columnaRotulo);
		
		$('tbody').append(tr);
	}
}


var head = $("thead"); // busca los headers de la tabla
var columnas = 4; // numero de columnas de la tabla
$(document).ready( function( ) {
	
		ajaxCall();
		
});