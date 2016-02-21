var usuario = null;

function error(data){}


function cargarNiveles(){
	getForObject({size:9990}, "/api/niveles", function(niveles){
		niveles = niveles._embedded.niveles;
		var dropDown = $("#nivel");
		niveles.forEach(function(nivel){
			var option = $("<option>",{text: nivel.descripcion, value: nivel.nivelesPK.nivel})
			dropDown.append(option);
		});
		dropDown.val(usuario.nivel);
	}, error);
}


/**
 * función que verifica que no exista ese nombre de usuario
 */
function verificar(){
	var usuario = $("#usuario").val();
	getForObject(null,"/api/users/"+ usuario, function(usuario){
		alert("Ese usuario ya existe, debe escoger  uno nuevo")
		$("#usuario").val("");
	},error);
}
/**
 * función que se ejecuta cuando carga el DOM
 */
$(document).ready(function(){
	var usuarioSeleccionado = get("usuario");

	getForObject(null, "/api/users/"+ usuarioSeleccionado , function(data){
		usuario = data;
		$("#niveles").val(usuario.nivel);
		$("#maxdias").val(usuario.maxdias);
		$("#diasalerta").val(usuario.diasalerta);
		$("#password").val(usuario.password);
		cargarNiveles();
	}, error ); // se obitiene la información del usuario y después se cargan los niveles
	
	$("#usuario").val(usuarioSeleccionado);
	$("form").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		for (var property in obj) {
		   usuario[property] = obj[property]; 
		}
		console.log(usuario);
		putForObject(usuario, "/api/usuarios/", creacionExitosa, errorAlCrear);
	});
});
/**
 * función que se ejecuta cuando la creación es exitosa
 */
function creacionExitosa(){
	alert("Se ha modificado exitosamente");
	location.reload();
}
/**
 * función que se ejecuta cuando hay un error al crear
 */
function errorAlCrear(){
	alert("Hubo un error fatal en la modificación")
}