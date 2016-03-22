/**
 * funcion que se trae por ajax la informacion necesaria
 */
function tabla(){
	$.ajax({
		url:'/api/articulos/search/darConExistencias',
		success:function(data){
			llenar(data._embedded.articulos);
		},
		error: function(){
			console.log('error al obtener los datos');
		}
	})
}
/**
 * funcion que se encarga de llenar la tabla con los modelos
 * @param articulos, los articulos a pintar
 */
function llenar(articulos){
	
	for (var i = 0; i < articulos.length; i++) {
		
		var codigo = $('<td>',{
			text: articulos[i].codigo,
		});
		codigo.addClass("codigo");
		
		var observacion_4 = $('<td>',{
			text: articulos[i].referencia
		});
		var nombre = $('<td>',{
			text: articulos[i].modelo1
		});
		var tipo = $('<td>',{
			text: articulos[i].modelo2
		});;
		var direccion = $('<td>',{
			text: articulos[i].modelo3
		});
		var telefonos = $('<td>',{
			text: articulos[i].marca	
		});
		var observacion_1 = $('<td>',{
			text: articulos[i].cantdisp
		});
		
		var observacion_2 = $('<td>',{
			text: articulos[i].refvendedor
		});
		var observacion_3 = $('<td>',{
			text: articulos[i].modelvendedor
		});
		
		var fila = $('<tr>');
		fila.append(codigo);
		fila.append(observacion_4);
		fila.append(nombre);
		fila.append(tipo);
		fila.append(direccion);
		fila.append(telefonos);
		fila.append(observacion_1);
		fila.append(observacion_2);
		fila.append(observacion_3);
		$('tbody').append(fila);
	}
}

/**
 * funcion que se ejecuta cuando se le da clic a una de las ubicaciones
 */
function clicFila(){
	var codigo = $(this).find('.codigo').text();
	window.location = 'editar/?codigo='+codigo;
}



var head = $("thead"); // busca los headers de la tabla
var columnas = 9; // numero de columnas de la tabla
/**
 * funcion que se ejecuta cuando el documento esta listo
 */
$(document).ready(function() {
			tabla();
			$("body").append($("<style>", {text : "td{ width:" +90 / columnas + "vw; max-width:90vw;	}"}))
			$(window).scroll(function() {
				if(head.position().top -$(this).scrollTop() < 0 ){
					head.css("position", "fixed");
					head.css("top", "0px");
					head.css("width", "90vw");
					head.find("th").each(function(el){
						$(this).css("width", 90 / columnas + "vw")
					});
					$('table').find("td").each(function(el){
						$(this).css("width", 90 / columnas + "vw")
					});
				}else{
					head.css("position", "");
					head.css("top", "");
				}
			});
			$("table").on("click","tr", clicFila);
});