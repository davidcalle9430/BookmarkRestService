function error(data){}
/**
 * función que verifica si el identificador no ha sido usado
 */
function verificar(){
	var id = $("#identificacion").val();
	getForObject(null,"/api/proveedores/"+ id, function(zona){
		alert("Esa id ya existe, debe escoger uno nuevo");
		$("#identificacion").val("");
	},error);
}

function cargarCiudades(){
	getForObject({size:9999}, "/api/ciudades", function(ciudades){
		ciudades = ciudades._embedded.ciudades;
		var select = $("#ciudad");
		ciudades.forEach(function(ciudad){
			var option = $("<option>", {text: ciudad.ciudad, value : ciudad.codigo});
			select.append(option);
		});
	}, error);
}
/**
 * 
 */
$(document).ready(function(){
	cargarCiudades();
	
	$("form").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		obj.ciudad = "/api/ciudades/"+ obj.ciudad;
		obj.fechamod = darFechaActual();
		console.log(obj);
		postForObject(obj, "/api/proveedores", creacionExitosa, errorAlCrear);
	});
});
function creacionExitosa(){
	alert("Se ha creado exitosamente");
	location.reload();
}
function errorAlCrear(){
	alert("Hubo un error fatal en la creación")
}