function errorCarga(){		
	alert("Error al cargar el elemento");		
	window.location = "/jm/";		
}		
/**		
* función que carga los datos del formulario		
*/		
function cargarDatos(){		
	var cod = get("codigo");		
	getForObject(null,"/api/textosFactura/"+cod, function(data){		
		$("#codigo").val(data.codigo);		
		$("#texto1").val(data.texto1);		
		$("#texto2").val(data.texto2);		
		$("#texto3").val(data.texto3);		
		$("#dias").val(data.dias);		
		$("#porcentaje").val(data.porcentaje);		
				
	}, errorCarga);		
}		
/**		
* función que se ejcuta cuando carga el DOM		
*/		
$(document).ready(function(){		
	cargarDatos();		
	$("form").submit(function(ev){		
		ev.preventDefault();		
		var obj = $(this).serializeObject();		
		putForObject(obj, "/api/textosFactura/"+obj.codigo, exito, error);		
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