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
	var formulario = $("#editar").first();
	llenarFormularioObjeto(formulario, data);
}
var cargarLinea = function(data){
	$("#lineas").first().val(data.linea);
}
var cargarCodCorr = function(data){
	console.log(data.codigo);
	$("#corrers").first().val(data.codigo);
}

var cargarCiudad = function(data){
	console.log(data.codigo);
	$("#ciudades").first().val(data.codigo);
}


var cargarVendedor = function(data){
	$("#vendedores").first().val(data.codigo);
}
var cliente = get("codigo");
/**
 * función que se ejecuta en el momento de que se carga el docuemento
 */
$(document).ready(function() {
	cargarValores();
	var formulario = $("#editar").first();
	var uri = "/api/clientes/" + cliente;
	getForObject(null, uri , cargarCliente);
	getForObject(null, uri +"/codcorr" , cargarCodCorr);
	getForObject(null, uri +"/linea" , cargarLinea);
	getForObject(null, uri +"/ciudad" , cargarCiudad);
	getForObject(null, uri +"/vendedor" , cargarVendedor);
});

$("#editar").first().submit(function(ev){
	ev.preventDefault();
	console.log("oprimió editar");
});

$("#eliminar").first().submit(function(ev){
	ev.preventDefault();
	console.log("oprimió eliminar");
});