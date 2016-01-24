/**
 * función que se ejecuta cuando carga el dom 
 */
$(document).ready(function(){
	var codigo = get("codigo");
	getForObject(null, "/api/corrers/"+codigo , cargarCorreria , error);
	$("form").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		if ($("#iva").prop("checked")) {
			obj.iva = true;
		} else {
			obj.iva = false;
		}
		obj.fecha = darFechaActual();
		putForObject(obj, "/api/corrers/"+obj.codigo, exito, error);
	});
});
/**
 * función que se ejecuta cuando la acutalización es correcta
 */
function exito(){
	alert("Actualización Completa");
	location.reload();
}
/**
 * función que se ejecuta cuando hay un error en el código
 */
function error(){
	alert("Hubo un error al acutalizar");
	location.reload();
}
/**
 * función que carga la correría actual
 * @param correr
 */
function cargarCorreria(correr){
	$("#codigo").val(correr.codigo);
	$("#nombre").val(correr.nombre);
	if(correr.iva){
		document.getElementById('iva').checked = true;
	}else{
		document.getElementById('iva').checked = false;
	}
}
/**
 * función que se ejcuta cuando no encuentra la correr
 * @param datos
 */
function error( datos ){
	alert("No existe la correría");
	location.href = "/jm/";
}
