/* 
 * función encargada la tabla a partir de una lista de elementos
 * Debe tener al menos un elemento para que funcione
 * recibe el atributo de la lista de propiedades que se quiere usar
 */

function cargarEncabezados(lista, propiedades, aMostrar) {
	var primero = lista[0];
	var tr = $("<thead>");
	for (atributo in primero) {
		if (propiedades.indexOf(atributo) != -1) {
			var th = $("<th>");
			th.html(aMostrar[propiedades.indexOf(atributo)]);
			tr.append(th);
		}
	}
	var tabla = $("table").first();
	tabla.append(tr);
	head = $("thead");
}
function cargarTabla(lista, propiedades, aMostrar, indice) {
	if (indice == 0) {
		cargarEncabezados(lista, propiedades, aMostrar);
		dobleClic(manejador);
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
			url : "/api/clientes/?page=" + indice + "&sort=codigo",
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

/*
 * Función que se encarga de añadir un handler para cada fila
 * 
 */

function dobleClic(manejador) {
	console.log("entra al manejador");
	$("body").on("click","tr", manejador);

}
var manejador = function() {
	var hijos = $(this).children();
	console.log(hijos);
	window.location = "editar/?codigo="+ hijos[0].innerHTML;
}

/**
 * función encargada de crear una tabla
 * 
 * 
 */
var tamMax = null; // variable que guarda el tamaño máximo de la página
var paginaActual = 0;
var alFinal = false; // variable que determina si está al final de la pagina
var columnas = 5;
var head = $("thead");
$(document).ready(function() {
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
							if (!alFinal) {
								alFinal = true;
								cargarClientes(paginaActual, loader, tamMax);
								
							}
						}
						
						if(head.position().top -$(this).scrollTop() < 0 ){
							head.css("position", "fixed");
							head.css("top", "0px");
							head.css("left", "0px");
							head.find("th").each(function(el){
								$(this).css("width", 100 / columnas + "vw" )
							})
						}else{
							head.css("position", "");
							head.css("top", "");
							head.css("left", "");
						}
					});
		});
