var ciudadElegida = null;
/**
 * funci{on que se ejecuta cuando carga el DOM
 */
$(document).ready(function(){
	cargarCiudad();
});
/**
 * función que carga la ciudad mandada en el parámetro  get
 */
function cargarCiudad(){
	var codigo = get("codigo");
	getForObject(null, "/api/ciudades/"+codigo, function(ciudad){
		ciudadElegida = ciudad;
		$("#codigo").val(ciudad.codigo);
		$("#ciudad").val(ciudad.ciudad);
		
	}, error);
	$("#editar").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		ciudadElegida.ciudad = obj.ciudad;
		putForObject(ciudadElegida, "/api/ciudades/"+ciudadElegida.codigo,actualizacionCompleta, errorActualizacion );	
	});
	$("#eliminar").submit(function(ev){
		ev.preventDefault();
		deleteForObject("/api/ciudades/"+ciudadElegida.codigo, exitoBorrado, errorActualizacion);
	});
}
/**
 * función que se ejecuta cuando se completa una actualización
 */
function actualizacionCompleta(){
	alert("actualización completa");
	window.location = "/jm/";
}
/**
 * función que se ejecuta cuando hay un error en la acutalización
 */
function exitoBorrado(){
	alert("Borrado exitoso");
	window.location = "/jm/";
}
/**
 * función que se ejecuta cuando hay un error en la acutalización
 */
function errorActualizacion(){
	alert("Error en la actualización");
	//window.location = "/jm/";
}
/**
 * función que se ejecuta cuando la ciudad no exite
 */
function error(){
	alert("La ciudad no existe");
	window.location = "/jm/";
}