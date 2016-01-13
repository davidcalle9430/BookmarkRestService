var existe = false;
var exitoBuscar = function(data){
	existe = true;
	alert("Ya existe, no puede crear uno nuevo");
}

var errorBuscar = function(data){
	alert("No se encontró, puede proseguir correctamente");
	existe = false;
}
function buscarCodigo(){
	var codigo = parseInt($("#codigo").val());
	getForObject(null,"/api/generos/"+codigo, exitoBuscar, errorBuscar);
}
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
		if(!existe){
			postForObject(obj,"/api/generos",exito,error);
		}else{
			alert("No se puede crear uno nuevo sobre uno que ya existe");
		}
		
		
	});
});