var articulo = null;
var esNuevo = true; // define si el artículo es nuevo
/**
 * Tomada de
 * http://stackoverflow.com/questions/2998784/how-to-output-integers-with-leading-zeros-in-javascript
 * función encargada de formatear con ceros
 */
function zeroPad(num, places) {
	var zero = places - num.toString().length + 1;
	return Array(+(zero > 0 && zero)).join("0") + num;
}
/**
 * de borrar el acutal
 */
function borrarAsignar() {
	$("#codigo-asignar").first().val("");
	$("#codigo").first().val("");
}
/**
 * Función que se encarga de limiar el formulario
 */

function limpiarFormulario() {
	$("#referencia").first().val(" ");
	$("#refvendedor").first().val(" ");
	$("#marca").first().val(" ");
	$("#uso").first().val(" ");
	$("#modelvendedor").first().val(" ");
	$("#modelo1").first().val(" ");
	$("#modelo2").first().val(" ");
	$("#modelo3").first().val(" ");
	$("#procedenc").first().val(" ");
}
/**
 * Función encargada de llenar el formulario
 */
function llenarArticulo(articulo) {
	$("#referencia").first().val(articulo.referencia);
	$("#refvendedor").first().val(articulo.refvendedor);
	$("#marca").first().val(articulo.marca);
	$("#uso").first().val(articulo.uso);
	$("#modelvendedor").first().val(articulo.modelvendedor);
	$("#modelo1").first().val(articulo.modelo1);
	$("#modelo2").first().val(articulo.modelo2);
	$("#modelo3").first().val(articulo.modelo3);
	$("#procedenc").first().val(articulo.procedenc);
}

/**
 * Función encargada de buscar un artículo
 */
function buscarArticulo() {
	var inicioCodigo = parseInt($("#codigo-grupo").first().val());
	var finCodigo = $("#codigo-asignar").first().val();
	finCodigo = zeroPad(parseInt(finCodigo), 3);
	var codigo = parseInt(inicioCodigo + "" + finCodigo);
	articulo = codigo;
	$("#codigo").first().val(codigo);
	if (finCodigo != "000") {
		$.ajax({
			url : "/api/articulos/" + codigo,
			success : function(data) {
				console.log(data);
				esNuevo = false;
				llenarArticulo(data);
			},
			error : function(data) {
				alert("Artículo no Existe, se creará uno nuevo")
				limpiarFormulario();
			}
		});
	} else {
		limpiarFormulario();
		var enteroInicio = parseInt(inicioCodigo) * 1000;
		var enteroFin = enteroInicio + 1000;
		console.log(enteroInicio + "-" + enteroFin);
		var insertarCodigoGenerado = function(codigo) {
			codigo = parseInt(codigo) + 1;
			$("#codigo").first().val(codigo);
		}
		var insertarCodigoGeneradoNuevo = function(codigo) {
			console.log("hay que generarlo")
			$("#codigo").first().val(enteroInicio + 1);
		}
		getForObject({
			min : enteroInicio,
			max : enteroFin
		}, "/api/articulos/search/darSiguienteCodigoCategoria",
				insertarCodigoGenerado, insertarCodigoGeneradoNuevo);
	}

}

var errorAgregar = function() {
	alert("Error al agregar");
}

var exitoAgregar = function() {
	alert("Agregado Correctamente");
}

var exitoActualizar = function() {
	alert("Actualizado Correctamete");
}

var errorActualizar = function() {
	alert("Hubo un error al actualizar");
}

var exitoEliminar = function() {
	alert("Eliminado Correctamente");
}

var errorEliminar = function() {
	alert("Error al eliminar");
}
/**
 * 
 */
$(document).ready(
		function() {
			$("#editar").submit(
					function(ev) {
						ev.preventDefault();
						var artic = $("#editar").serializeObject();
						console.log(articulo);
						if (!esNuevo) {
							putForObject(artic, "/api/articulos/" + articulo,
									exitoActualizar, errorActualizar);
						} else {
							postForObject(artic, "/api/articulos",
									exitoAgregar, errorAgregar);
						}
					});
			$("#eliminar").submit(function(ev) {
				ev.preventDefault();
				var eliminar = confirm("Está seguro que desea elminar");
				if (eliminar) {
					$.ajax({
						contentType : 'application/json; charset=utf-8',
						type : "delete",
						url : "/api/articulos/" + articulo,
						success : function(data) {
							alert("Eliminado Correctamente");
							window.location = "/mnuactacri/";
						},
						error : function(data) {
							alert("Error al elminar el cliente");
						}
					});
				}

			});
		});