/**
 * función que carga las ciduades
 */
var cargarCiudades = function(ciudades){
	var ciudades = ciudades._embedded.ciudades;
	var select = $('#ciudades').first();
	for(var i = 0; i < ciudades.length ; i++){
		var ciudad = ciudades[i];
		var option = $("<option/>",{ value : ciudad.codigo, text : ciudad.ciudad });
		select.append(option);
	}
}
/**
 * función que carga los corrers a un select
 */
var cargarCorrers = function(corrers){
	var corrers = corrers._embedded.corrers;
	var select = $('#corrers').first();
	for(var i = 0; i < corrers.length ; i++){
		var correr = corrers[i];
		var option = $("<option/>",{ value : correr.codigo, text : correr.nombre });
		select.append(option);
	}
}
/**
 * función qque carga los vendedores a uns select
 */
var cargarVendedores = function(vendedores){
	var vendedores = vendedores._embedded.vendedores;
	var select = $('#vendedores').first();
	for(var i = 0; i < vendedores.length ; i++){
		var vendededor = vendedores[i];
		var option = $("<option/>",{ value : vendededor.codigo, text : vendededor.nombre });
		select.append(option);
	}
}
/**
 * función qque carga las lìneas a un select
 */
var cargarLineas = function(lineas){
	var lineas = lineas._embedded.lineas;
	var select = $('#lineas').first();
	for(var i = 0; i < lineas.length ; i++){
		var linea = lineas[i];
		var option = $("<option/>",{ value : linea.linea, text : linea.descripcion });
		select.append(option);
	}
}


function validarExistencia(){
	var val = $("#cc").first().val();
	getForObject({cc : val}, "http://localhost/api/clientes/search/findAllByCc", existe);
	
}

var existe = function(data){
	if(data._embedded.clientes.length >= 1){
		alert("El cliente ya existe");
	}
}

/**
 * Función asociada a la creación exitosa del cliente
 */
var creacionCliente = function(data){
	alert("El cliente fue creado exitosamente");
}

var errorCreacion = function(data){
	alert("Error en la creación");
}
/**
 * función que se ejecuta cuando se oprime el botón
 */
var crearClienteBoton = function(evento){
	evento.preventDefault();
	console.log("Oprimieron el botòn");
	var nuevo = $(this).serializeObject();
	nuevo.ciudad = "/api/ciudades/" + nuevo.ciudad;
	nuevo.codcorr = "/api/corrers/" + nuevo.codcorr;
	nuevo.linea = "/api/lineas/" + nuevo.linea;
	nuevo.vendedor = "/api/vendedores/" + nuevo.vendedor;
	nuevo.zona = "/api/zonas/" + nuevo.zona;
	nuevo.fechamodif = darFechaActual();
	nuevo.nuevo = "S";
	postForObject(nuevo, "/api/clientes", creacionCliente, errorCreacion);
}

/**
 * función encargada de obtener el nuevo id, basado en la seleccion del usuario
 * el anterior desarrollado deciciòn que menos de 999 es un cleinte activo, si no, es del otro
 */
var cargarCodigo = function(codigoActual){
	$("#codigo").first().val(codigoActual + 1);
}

/**
 * Función que se encarga de llenar los dropdown
 */
function cargarValores(){
	$.when(getForObject({sort : "codigo,desc",size : 1000}, "/api/ciudades", cargarCiudades),
	getForObject({sort : "codigo,desc",size : 1000}, "/api/corrers", cargarCorrers),
	getForObject({sort : "codigo,desc",size : 1000}, "/api/vendedores", cargarVendedores),
	getForObject({sort : "linea,desc",size : 1000}, "/api/lineas", cargarLineas),
	getForObject({max: 999}, "/api/clientes/search/encontrarSiguienteId", cargarCodigo)).done(function(){
		
		
	})
	
	
}

/**
 * función que carga el id cuando cambia la selección y es por código
 */
function clienteConCodigo(){
	getForObject({max: 999}, "/api/clientes/search/encontrarSiguienteId", cargarCodigo);
}
/**
 * función que carga el id cuando cambia la selección y es ocasional
 */
function clienteOcasional(){
	getForObject({max: 999000}, "/api/clientes/search/encontrarSiguienteIdOcasional", cargarCodigo);
}