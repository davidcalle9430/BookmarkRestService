var usuario = null;

function exito() {
	alert("contraseña actualizada correctamente");
	window.location = "/";
}
function error() {
	alert("Error al actualizar la contraseña");
}
/**
 * función que se ejecuta al tener todos los elementos del DOM cargados
 */

$(document).ready(function() {
	getForObject(null, "/api/seguridad/autenticacion/", function(actual) {
		usuario = actual;
		$("#user").val(usuario.usuario);
	});

	$("form").submit(function(ev) {
		ev.preventDefault();
		var obj = $("form").serializeObject();
		console.log(obj);
		if (obj.nvacontra != obj.nvacontra1) {
			alert("La nueva contraseña no coincide");
			return;
		}
		if (usuario.password != obj.password) {
			alert("La contrasenia antigua es incorrecta");
			return;
		}
		usuario.password = obj.nvacontra;
		console.log(JSON.stringify(usuario));
		postForObject(usuario, "/api/seguridad/autenticacion/", exito, error);

	})
});