var pagina = 0;
var alFinal = false;

/**
 * función que trae toda la información necesaria por ajax
 */
function ajaxCall() 
{
	$.ajax({
		url : '/api/clientes?sort=razsoc&page=' + pagina,
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
 * función que crea una fila a partir de un cliente
 * @param clientes
 */
function crearFila(clientes) 
{
	clientes = clientes._embedded.clientes;
	for (var i = 0; i < clientes.length; i++) {
		var columnaCodigo = $('<td>', {
			text : clientes[i].codigo
		});
		var columnaRazsoc = $('<td>', {
			text : clientes[i].razsoc
		});
		var columnaDireccion = $('<td>', {
			text : clientes[i].direccion
		});
		var columnaTelefono = $('<td>', {
			text : clientes[i].telefono
		});
		var columnaCamref = $('<td>', {
			text : clientes[i].camref
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

/**
 * función que se ejectua cuando se le da clic a una fila
 */
function clicFila()
{
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML;
}
/**
 * función que se ejecuta una vez se haya cargado todo el documento
 */
var head = $("thead"); // busca los headers de la tabla
var columnas = 5; // numero de columnas de la tabla
$(document).ready(function() 
{
			ajaxCall();
			$(window).scroll(function() {
						if ($(window).scrollTop() + $(window).height() > $(document).height() - 50) {
							if (!alFinal) {
								alFinal = true;
								ajaxCall();
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
			$("table").on("click","tr", clicFila);
});