var nfact = null;
/**
 * 
 */
$(document).ready(function(){
	getForObject(null, "/api/nfact/1", function(data){
		nfact = data;
		$("#valret").val(nfact.valret);
	});
	
	$("form").submit(function(ev){
		ev.preventDefault();
		var nuevo = $("#valret").val();
		nfact.valret = nuevo;
		putForObject(nfact, "/api/nfact/1", exito, error);
	})
});


/**
* funcion que se ejecuta cuando la actualizacion es exitosa
*/
function exito(){
	alert("Actualización completa");
	location.reload();
}
/**
 * función que se ejecuta cuando la actualización no se logra corectamente
 */
function error(){
	alert("Error al acutalizar");
	location.reload();
}