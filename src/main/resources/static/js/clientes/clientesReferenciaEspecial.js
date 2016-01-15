var pagina = 0;
var alFinal = false;
function ajaxCall(){
	$.ajax({
		url: '/api/clientes?sort=razsoc&page='+pagina,
		success: function(data){
			crearFila(data);
			alFinal=false;
			pagina++;
		},
		error: function(data){
			console.log("Error al recuperar los datos");
		}
	})
}

function crearFila( clientes ){
	clientes = clientes._embedded.clientes;
	for( var i=0; i<clientes.length; i++){
		var columnaCodigo = $('<td>', {
			text: clientes[i].codigo
		});
		var columnaRazsoc = $('<td>', {
			text: clientes[i].razsoc
		});
		var columnaDireccion = $('<td>', {
			text: clientes[i].direccion
		});
		var columnaTelefono = $('<td>', {
			text: clientes[i].telefono
		});
		var columnaCamref = $('<td>', {
			text: clientes[i].camref
		});
		var tr = $('<tr>');
		tr.append(columnaCodigo);
		tr.append(columnaRazsoc);
		tr.append(columnaDireccion);
		tr.append(columnaTelefono);
		tr.append(columnaCamref);
		$('tbody').append(tr);
	}
}

$(document).ready(
		function() {
			ajaxCall();
			$(window).scroll(
					function() {
						if ($(window).scrollTop() + $(window).height() > $(document).height() - 50) {
							if (!alFinal) {
								alFinal = true;
								ajaxCall();
							}
						}
					});
		})