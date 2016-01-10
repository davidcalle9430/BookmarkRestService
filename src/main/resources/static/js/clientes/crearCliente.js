var cargarCiudades = function(ciudades){
	var ciudades = ciudades._embedded.ciudades;
	var select = $('#ciudades').first();
	for(var i = 0; i < ciudades.length ; i++){
		var ciudad = ciudades[i];
		var option = $("<option/>",{ value : ciudad.codigo, text : ciudad.ciudad });
		select.append(option);
	}
}
var cargarCorrers = function(corrers){
	var corrers = corrers._embedded.corrers;
	var select = $('#corrers').first();
	for(var i = 0; i < corrers.length ; i++){
		var correr = corrers[i];
		var option = $("<option/>",{ value : correr.codigo, text : correr.nombre });
		select.append(option);
	}
}
var cargarVendedores = function(vendedores){
	var vendedores = vendedores._embedded.vendedores;
	var select = $('#vendedores').first();
	for(var i = 0; i < vendedores.length ; i++){
		var vendededor = vendedores[i];
		var option = $("<option/>",{ value : vendededor.codigo, text : vendededor.nombre });
		select.append(option);
	}
}
var cargarLineas = function(lineas){
	var lineas = lineas._embedded.lineas;
	console.log(lineas);
	var select = $('#lineas').first();
	for(var i = 0; i < lineas.length ; i++){
		var linea = lineas[i];
		var option = $("<option/>",{ value : linea.linea, text : linea.descripcion });
		select.append(option);
	}
}
/*
 * Método que funciona como un wrapper a los request AJAX GET
 */
function getForObject(object, url, toDo){
	$.ajax({
		url : url + "?" + $.param(object),
		success : function(data){
			console.log(url + "?" + $.param(object));
			toDo(data);	
		},
		error: function(data){
			console.log("Hubo un error en la consulta " + url);
		}
	});
}
/**
 * Función que se carga cuando el cliente está listo, se seleccciona como límite de ciudades 1000
 */
$(document).ready(function(){
	console.log("El Documento está listo");
	getForObject({sort : "codigo,desc",size : 1000}, "/api/ciudades", cargarCiudades);
	getForObject({sort : "codigo,desc",size : 1000}, "/api/corrers", cargarCorrers);
	getForObject({sort : "codigo,desc",size : 1000}, "/api/vendedores", cargarVendedores);
	getForObject({sort : "linea,desc",size : 1000}, "/api/lineas", cargarLineas);
});

