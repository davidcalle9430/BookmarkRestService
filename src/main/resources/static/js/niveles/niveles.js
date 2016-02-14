/**
 * 
 */
var pagina = 0;
var alFinal = false;
/**
 * petición ajax para obtener todos los niveles
 */
function ajaxCall() {
	$.ajax({
		url : '/api/niveles?page=' + pagina,
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
	niveles = niveles._embedded.niveles;
	for (var i = 0; i < niveles.length; i++) {
		var tr = $("<tr>");
		var columnaCodigo = $('<td>', {
			text : niveles[i].nivelesPK.nivel
		});
		var columnaNombre = $('<td>', {
			text : niveles[i].descripcion
		});
		tr.append(columnaCodigo);
		tr.append(columnaNombre);
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
var columnas = 2; // numero de columnas de la tabla
$(document).ready(function() {
			ajaxCall();
			$("body").append($("<style>", {text : "td{width:" +100 / columnas + "vw;	}"}))
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