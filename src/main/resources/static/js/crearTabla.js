/* 
 * función encargada la tabla a partir de una lista de elementos
 * Debe tener al menos un elemento para que funcione
 * recibe el atributo de la lista de propiedades que se quiere usar
 */

function cargarEncabezados(lista, propiedades, aMostrar) {
	var primero = lista[0];
	var tr = $("<tr>");
	for (atributo in primero) {
		if (propiedades.indexOf(atributo) != -1) {
			var th = $("<th>");
			th.html(aMostrar[propiedades.indexOf(atributo)]);
			tr.append(th);
		}
	}
	var tabla = $("table").first();
	tabla.append(tr);

}
function cargarTabla(lista, propiedades, aMostrar, indice) {
	if (indice == 0) {
		cargarEncabezados(lista, propiedades, aMostrar);
	}
	var tabla = $("table").first();
	for (var i = 0; i < lista.length; i++) {
		var elemento = lista[i];
		var tr = $("<tr>");
		for (atributo in elemento) {
			if (propiedades.indexOf(atributo) != -1) {
				var td = $("<td>");
				td.html(elemento[atributo]);
				tr.append(td);
			}
		}
		tabla.append(tr);
	}
}

/**
 * Función encargada de traer los clientes por ajax
 */

function cargarClientes(indice, loader) {
	if (indice <= tamMax || tamMax == null) {
		$.ajax({
			url : "/api/clientes/?page=" + indice+"&sort=codigo,desc",
			success : function(data) {
				console.log("página " + indice)
				cargarTabla(data._embedded.clientes, [ "codigo", "razsoc",
						"direccion", "telefono", "ciudad", "nit" ], [ "Código",
						"Razón Social", "Dirección", "Teléfono", "Ciudad",
						" NIT" ], indice);
				loader.css({
					display : "none"
				});	
				tamMax = data.page.totalPages;
				if (paginaActual <= tamMax) {
					paginaActual++;
					alFinal = false;
				}

			}
		})
	}
}
/**
 * función encargada de crear una tabla
 * 
 * 
 */

var tamMax = null; // variable que guarda el tamaño máximo de la página
var paginaActual = 0;
var alFinal = false; // variable que determina si está al final de la pagina para recargar
$(document).ready(
		function() {
			var body = $("body").first();
			var table = $("<table>", {
				id : "tabla"
			});
			var tabla = $("table").first();
			var loader = $(".loader").first();
			loader.css({
				display : "block"
			});
			body.append(table);
			var tablaDom = $("table").first();
			cargarClientes(paginaActual, loader);
			$(window).scroll(
					function() {
						if ($(window).scrollTop() + $(window).height() > $(
								document).height() - 50) {
							if(!alFinal){
								alFinal = true;
								cargarClientes(paginaActual, loader, tamMax);
							}
						}
					});
		});
