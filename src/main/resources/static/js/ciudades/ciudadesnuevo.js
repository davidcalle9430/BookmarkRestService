function cargarCodigoNuevo(){
	getForObject(null, "/api/ciudades/search/darNuevoCodigo", function(codigo){
		$("#codigo").val(codigo);
	});
}

/**
 * función que se ejecuta cuando carga el DOM
 */
$(document).ready(function(){
	cargarCodigoNuevo();
	$("form").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		postForObject(obj, "/api/ciudades" , actualizacionCompleta , error);
	});
});
/**
 * función que se ejecuta cuando la actualización es correcta
 */
function actualizacionCompleta(){
	alert("Actualización correcta");
	location.reload();
}
/**
 * función que se ejecuta cuando hay un error en la actualización
 */
function error(){
	alert("Error de actualización");
}