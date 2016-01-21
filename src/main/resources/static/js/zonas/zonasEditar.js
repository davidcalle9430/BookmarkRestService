var zona = null;
function error(data){
	alert("La zona ya no exite");
	window.location = "../";
}
/**
 * arichivo capturador de eventos del html
 */
$(document).ready(function(){
	var nombreZona = get("zona");
	getForObject(null,"/api/zonas/"+nombreZona, function(data){
		zona = data;
		$("#zona").val(zona.zona);
		$("#nombre").val(zona.nombre);
	},error);
	
	// submit de editar
	$("#editar").submit(function(ev){
		ev.preventDefault();
		editado = $(this).serializeObject();
		zona.nombre = editado.nombre;
		putForObject(zona, "/api/zonas/"+zona.zona, exitoActualizacion, errorActualizar )
	});
	
	//submit del elimnar
	$("#eliminar").submit(function(ev){
		ev.preventDefault();
		var confirm = window.confirm("Seguro que desea eliminar");
		if(confirm){
			deleteForObject("/api/zonas/"+zona.zona, exitoBorrado, errorBorrado);
		}
	})
});
/**
 * función que se ejecuta después de un exito en la actulización
 * @returns 
 */
function exitoActualizacion(){
	alert("Actualización terminada");
}
/**
 * funcion que se ejecuta cuando hay un error en la actualización
 */
function errorActualizar(){
	alert("No se pudo actualizar la zona");
}

/**
 * función que se ejecuta después de un exito en la actulización
 * @returns 
 */
function exitoBorrado(){
	alert("Actualización terminada");
}
/**
 * funcion que se ejecuta cuando hay un error en la actualización
 */
function errorBorrado(){
	alert("No se pudo actualizar la zona");
}

