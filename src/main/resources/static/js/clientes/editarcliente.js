var cliente = null;
function llenarFormularioObjeto(formulario, objeto) {
	var objeto = objeto;
	formulario.find("input").each(function() {
		var atributo = this.name;
		var valor = objeto[atributo];
		if (valor != undefined) {
			$(this).val(objeto[atributo]);
		}
	});
}

var cargarCliente = function(data) {
	cliente = data;
	var formulario = $("#editar").first();
	llenarFormularioObjeto(formulario, data);
}
var cargarLinea = function(data) {
	$("#lineas").first().val(data.linea);
}
var cargarCodCorr = function(data) {
	$("#corrers").first().val(data.codigo);
}

var cargarCiudad = function(data) {
	$("#ciudades").first().val(data.codigo);
}

var cargarVendedor = function(data) {
	$("#vendedores").first().val(data.codigo);
}
var cliente = get("codigo");
var formulario = $("#editar").first();
var uri = "/api/clientes/" + cliente;

var cargarValoresFaltantes = function(){
	
}

var carga = false;
/**
 * función que se ejecuta en el momento de que se carga el docuemento
 */
$(document).ready(function() {
		cargarValores();
		getForObject(null, uri, cargarCliente);
		$(document).ajaxStop(function() {
			if(!carga){
				getForObject(null, uri + "/codcorr", cargarCodCorr);
				getForObject(null, uri + "/linea", cargarLinea);
				getForObject(null, uri + "/ciudad", cargarCiudad);
				getForObject(null, uri + "/vendedor", cargarVendedor);
				carga = true;
			}
		});
		
});

var confirmacionActualizacion = function(data) {
	alert("Cliente acutalizado correctamente");
	location.href = "/mnuclijm/";
}

var errorActualizacion = function(data) {
	alert("Error a actualizar el cliente");
}
$("#editar").first().submit(
		function(ev) {
			ev.preventDefault();
			var objeto = $(this).serializeObject();
			/* falta meter las uris de los objetos relacionados */
			objeto.ciudad = "/api/ciudades/" + objeto.ciudad;
			objeto.codcorr = "/api/corrers/" + objeto.codcorr;
			objeto.linea = "/api/lineas/" + objeto.linea;
			objeto.vendedor = "/api/vendedores/" + objeto.vendedor;
			objeto.zona = "/api/zonas/" + objeto.zona;
			objeto.fechamodif = darFechaActual();
			for(var atributo in objeto){
				cliente[atributo] = objeto[atributo];
			}
			putForObject(cliente, "/api/clientes/" + cliente.codigo,
					confirmacionActualizacion, errorActualizacion);
		});

$("#eliminar").first().submit(function(ev) {
	ev.preventDefault();
	var confirmacion = confirm("Está seguro que desea eliminar el usuario");
	if (confirmacion) {
		$.ajax({
			contentType: 'application/json; charset=utf-8',
			type: "delete",
			url : "/api/clientes/" + cliente,
			success : function(data){
				alert("Eliminado Correctamente");
				location.href = "/mnuclijm/";
			},
			error : function(data){
				alert("Error al elminar el cliente");
			}
		});
	}
});