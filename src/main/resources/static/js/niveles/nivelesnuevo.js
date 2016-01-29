$(document).ready(function() {
	console.log("carga");
	$("form").submit(function(ev) {
		ev.preventDefault();
		var obj = $(this).serializeObject();
		console.log(obj);
		obj.nivelesPK = new Object();
		obj.nivelesPK.nivel = obj.nivel;
		obj.nivelesPK.empresa = 1;
		obj.fecha = darFechaActual();
		postForObject(obj, "/api/niveles", exito, error);
	});
});

function exito(){
	alert("Éxito al crear");
	//location.href = "/jm/";
}
function error(){
	alert("Error al crear");
	//location.href = "/jm/";
}
/**
 * función que verifica que el código no exista previamente
 */
function verificar() {
	var codigo = $("#nivel").val();
	getForObject(null, "/api/niveles/" + codigo, function(correr) {
		alert("El código ya está en uso");
		var codigo = $("#nivel").val("");
	});
}