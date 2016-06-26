

function ajaxCall() {
	$.ajax({
		url : '/api/proveedores?projection=ciudad&size=9999999',
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

function crearFila(proveedores) {
	proveedores = proveedores._embedded.proveedores;
	for (var i = 0; i < proveedores.length; i++) {
		
		var tr = $("<tr>");
		
		var columnaId = $('<td>', {
			text : proveedores[i].identificacion
		});
		
		var columnaNombre = $('<td>', {
			text : proveedores[i].nombre
		});
		
		var columnaDireccion = $('<td>', {
			text : proveedores[i].direccion
		});
		
		var columnaTelefono = $('<td>', {
			text : proveedores[i].telefono
		});
		
		var columnaCiudad = $('<td>', {
			text : proveedores[i].ciudad.ciudad
		});
		
		tr.append(columnaId);
		tr.append(columnaNombre);
		tr.append(columnaDireccion);
		tr.append(columnaTelefono);
		tr.append(columnaCiudad);
		
		$('tbody').append( tr );
	}
}
function clicFila(){
	var hijos = $(this).children();
	window.location = "editar/?proveedor="+hijos[0].innerHTML;
}

var head = $("thead"); // busca los headers de la tabla

$( document ).ready(function() {
	
			ajaxCall();
			
			$("table").on("click","tr", clicFila);
});