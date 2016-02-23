/**		
 * función que veridfica que exita el código digitado		
 */		
function verificarExistencia(){		
	var codigo = $("#codigo").val();		
	getForObject(null, "/api/textosFactura/"+codigo, function(data){		
		alert("El código ya fue asignado anteriormente");		
		$("#codigo").val("");		
	})		
			
}		
		
/**		
 * función que se ejcuta cuando carga el DOM		
 */		
$(document).ready(function(){		
	$("form").submit(function(ev){		
		ev.preventDefault();		
		var obj = $(this).serializeObject();		
		postForObject(obj, "/api/textosFactura", exito, error);		
	});		
})		
		
/**		
* función que se ejecuta cuando hay un éxito en la actualización		
*/		
function exito(){		
	alert("Actualización completada");		
	location.reload();		
}		
/**		
 * 		
 */		
function error(){		
	alert("Error al acutalizar");		
	location.reload();		
}