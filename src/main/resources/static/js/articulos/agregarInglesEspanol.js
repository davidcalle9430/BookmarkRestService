
var exito = function(){
	alert("Creado exitosamente");
}
var error = function(){
	alert("Error al crear");
}
/**
 * 
 */
$(document).ready(function(){
	$("form").first().submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		postForObject(obj,"/api/generos",exito,error);
		
	});
});