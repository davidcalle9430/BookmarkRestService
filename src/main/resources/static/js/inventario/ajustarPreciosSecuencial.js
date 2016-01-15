var alFinal = false;
var pagina = 0;
function crearFila(articulos) {
	articulos = articulos._embedded.articulos;
	var codigo, nombre, referencia, precio;
	for (var i = 0; i < articulos.length; i++) {
		var ColumnaNombre = $("<td>", {
			text : articulos[i].marca
		});
		var ColumnaCodigo = $("<td>", {
			text : darCodigoFormateado( articulos[i].codigo )
		});
		var ColumnaReferencia = $("<td>", {
			text : articulos[i].referencia
		});
		var ColumnaPrecio = $("<td>", {
			text : articulos[i].precio
		});
		var fila = $("<tr>");
		fila.append(ColumnaCodigo);
		fila.append(ColumnaNombre);
		fila.append(ColumnaReferencia);
		fila.append(ColumnaPrecio);
		$('tbody').append(fila);
	}
}

function nAjax(){
	$.ajax({
		url : '/api/articulos?page='+pagina,
		success : function(data) {
			crearFila(data);
			alFinal=false;
			pagina++;
		},
		error : function(data) {
			console.log('fail');
		}
	})
}

$(document).ready(
		function() {
			nAjax();
			$(window).scroll(
					function() {
						if ($(window).scrollTop() + $(window).height() > $(document).height() - 50) {
							if (!alFinal) {
								alFinal = true;
								nAjax();
							}
						}
					});
			
			$('table').on('click','tr', function(){
				var hijos = $(this).children();
				alert('toca todavía hacerla' + hijos[0].innerHTML);
			})
		})