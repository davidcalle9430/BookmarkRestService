
var pagina = 0; // pagina en la que va al hace scroll
var alFinal = false; // variable que verifica que esté al final del  window
/**
 * petición ajax para obtener todos los niveles
 */
function ajaxCall() {
	$.ajax({
		url : '/api/opcionesniveles/?size=999999page=' + pagina,
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
/**
 * función que se encarg de crear una fila para cada uno de los niveles
 * @param niveles, referencia a lista de niveles a crear
 */
function crearFila(niveles) {
	console.log(niveles);
	for (var i = 0; i < niveles.length; i++) {
		var tr = $("<tr>");
		var columnaNivel = $('<td>', {
			text : niveles[i].nivel
		});
		var columnaNombre = $('<td>', {
			text : niveles[i].nombre
		});
		var columnaCodigoMenu = $('<td>', {
			text : niveles[i].codMenu
		});
		var columnaNombreMenu = $('<td>', {
			text : niveles[i].nombreMenu
		});
		tr.append(columnaNivel);
		tr.append(columnaNombre);
		tr.append(columnaCodigoMenu);
		tr.append(columnaNombreMenu);
		$('tbody').append(tr);
	}
}
/**
 * función que se ejecuta cuando el usuario le da clic a una fila
 * es importante haber agregado el listener para su funcionamiento
 */
function clicFila(){
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML;
}

var head = $("thead"); // busca los headers de la tabla
var columnas = 4; // numero de columnas de la tabla
$(document).ready(function() {
	
			ajaxCall();
			
			$("table").on("click","tr", clicFila);
});