/**
 * función que se ejecuta cuando carga el dom 
 */
$(document).ready(function(){
	var codigo = get("codigo");
	getForObject(null, "/api/niveles/search/findOneByNivelesPK_nivel?nivel="+codigo , cargarCorreria , error);
	$("form").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		obj.nivelesPK = new Object();
		obj.nivelesPK.nivel = obj.nivel;
		obj.nivelesPK.empresa = 1;
		obj.fecha = formatearFechaISO(darFechaActual());
		putForObject(obj, "/api/niveles/actualizar", exito, errorAc);
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
function errorAc(){
	alert("Hubo un error al acutalizar");
	location.reload();
}
/**
 * función que carga la correría actual
 * @param correr
 */
function cargarCorreria(correr){
	$("#nivel").val(correr.nivelesPK.nivel );
	$("#descripcion").val(correr.descripcion);
}
/**
 * función que se ejcuta cuando no encuentra la correr
 * @param datos
 */
function error( datos ){
	alert("No existe la correría");
	location.href = "/jm/";
}
