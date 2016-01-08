var inputCodigo = $("#codigo").first();
var inputNombre = $("#nombre").first();
var inputDocumento = $("#documento").first();
var inputNDoc = $("#ndoc").first();
var inputCantidad = $("#cantidad").first();
var inputCantidadBodega = $("#cantBodega").first();
var forma = $('form').first();
var genero = null;
/**
 * función encargada de buscar en la entidad gènero el que tenga el id especificado
 */
function buscar() {
	var codigo = inputCodigo.val();
	$.ajax({
		url : "/api/generos/" + codigo,
		contentType: 'application/json; charset=utf-8',
		success : function(entrada){
			genero = entrada;
			console.log(entrada);
			inputNombre.val(entrada.nombre);
			inputCantidadBodega.val(entrada.cantdisp);	
		},
		error : function(data) {
			alert("El còdigo especificado no exite");
		}

	});

}
/**
 * función encargada de agregar los datos a la tabla cardexi
 */
function agregarACardexi(cardex){
	$.ajax({
		url : "/api/cardexi",
		type : "post",
		data : JSON.stringify(cardex),
		contentType: 'application/json; charset=utf-8',
		success : function(data){
			alert("Inserción en bodega completado correctamente");
		},
		error: function(data){
			alert("Error al insertar en bodega");
		}
	});
}

/**
 * Función que se encarga de actualizar	el genero a su nuevo estado
 * Se encarga también de actualizar el cardex, para evitar problemas 
 */
function actualizarGenero(genero, cardex){
	$.ajax({
		url : "/api/generos/"+genero.codigo,
		type : "put",
		data : JSON.stringify(genero),
		contentType: 'application/json; charset=utf-8',
		success : function(data){
			agregarACardexi(cardex);
		},
		error: function(data){
			alert("Error en la actualización");
		}
	});
}
/**
 * función encargada de escuchar el submit del formulario y actualizar la informaciòn del inventario en el servidor
 */
forma.submit(function(ev){
	ev.preventDefault();
	var button = $(this).find("button").first();
	button.attr('disabled',true);
	var cardex = new Object();
	var nombre = inputNombre.val();
	cardex.codigo = inputCodigo.val();
	cardex.documento = inputDocumento.val();
	cardex.ndoc = inputNDoc.val();
	cardex.saldo = 	(genero == null || genero.cantdisp == null) ? 0 : genero.cantdisp;
	cardex.saldo += parseInt(inputCantidad.val());
	cardex.cantidad = inputCantidad.val();
	genero.cantdisp = cardex.cantidad;
	cardex.fecha = darFechaActual();
	cardex.tipo = "E";
	actualizarGenero(genero,cardex);
	button.removeAttr("disabled");
});
