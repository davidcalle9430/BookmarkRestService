$(document).ready(function() {
	console.log("carga");
	$("form").submit(function(ev) {
		ev.preventDefault();
		var obj = $(this).serializeObject();
		if ($("#iva").prop("checked")) {
			obj.iva = true;
		} else {
			obj.iva = false;
		}
		obj.fecha = darFechaActual();
		postForObject(obj, "/api/corrers", exito, error);
	});
});

function exito(){
	alert("Éxito al crear");
	location.href = "/jm/";
}
function error(){
	alert("Error al crear");
	location.href = "/jm/";
}
/**
 * función que verifica que el código no exista previamente
 */
function verificar() {
	var codigo = $("#codigo").val();
	getForObject(null, "/api/corrers/" + codigo, function(correr) {
		alert("El código ya está en uso");
		var codigo = $("#codigo").val("");
	});
}