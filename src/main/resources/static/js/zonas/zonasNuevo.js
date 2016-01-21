function error(data){}
function verificar(){
	var zona = $("#zona").val();
	getForObject(null,"/api/zonas/"+ zona, function(zona){
		alert("Esa zona ya existe, debe escoger una nueva")
		$("#zona").val("");
	},error);
}
/**
 * 
 */
$(document).ready(function(){
	$("form").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		postForObject(obj, "/api/zonas", creacionExitosa, errorAlCrear);
	});
});
function creacionExitosa(){
	alert("Se ha creado exitosamente");
	location.reload();
}
function errorAlCrear(){
	alert("Hubo un error fatal en la creación")
}