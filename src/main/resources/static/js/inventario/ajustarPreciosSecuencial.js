var alFinal = false;
var pagina = 0;
function crearFila(articulos) {
	//articulos = articulos._embedded.articulos;
	var codigo, nombre, referencia, precio;
	for (var i = 0; i < articulos.length; i++) {
		var ColumnaNombre = $("<td>", {
			text : articulos[i].nombre
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
		url : '/api/articulos/search/articulosgeneros',
		success : function(data) {
			crearFila(data);
			alFinal=false;
			pagina++;
			$(".loader").css("display", "none");
			$("table").css("display","table");
		},
		error : function(data) {
			console.log('fail');
		}
	})
}
var head = $("thead"); // busca los headers de la tabla
var columnas = 4; // numero de columnas de la tabla
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
			
			$('table').on('click','tr', function(){
				var hijos = $(this).children();
				window.location = "/mnuajupi/?codigo="+hijos[0].innerHTML;
			})
		})