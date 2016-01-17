var cliente = null;
$(document).ready(function(){
	var codigo = get("codigo");
	// traer el cliente del parámetro get
	getForObject(null, "/api/clientes/"+codigo, function(data){
		cliente = data;
		$("#codigo").val(cliente.codigo);
		$("#razsoc").val(cliente.razsoc);
		$("#direccion").val(cliente.direcccion);
		$("#telefono").val(cliente.telefono);
		$("#camref").val(cliente.camref);
	}, noEncontrado);
	//atrapar el evento de submit del formulario
	$("#editar").submit(function(ev){
		ev.preventDefault();
		cliente.camref = $("#camref").val();
		putForObject(cliente, "/api/clientes/"+cliente.codigo, exito, error);
	});
	// atrapar el evento de submit del elminar
	$("#eliminar").submit(function(ev){
		ev.preventDefault();
		cliente.camref = $("#camref").val();
		deleteForObject("/api/clientes/"+cliente.codigo, exito, error);
	});
});
/**
 * mensaje cuando no se encuentra el cliente
 */
function noEncontrado(){
	alert("El actual cliente ya no existe u ocurrió un error en el servidor");
}
/**
 * mensaje cuando error de acutalización
 */
function error(){
	alert("Error al actualizar");
}
/**
 * mensaje cuando la acutalización es exitosa
 */
function exito(){
	alert("Actualización correcta");
}