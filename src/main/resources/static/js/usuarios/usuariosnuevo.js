function error(data){}

function cargarNiveles(){
	getForObject({size:9990}, "/api/niveles", function(niveles){
		niveles = niveles._embedded.niveles;
		var dropDown = $("#nivel");
		niveles.forEach(function(nivel){
			var option = $("<option>",{text: nivel.descripcion, value: nivel.nivelesPK.nivel})
			dropDown.append(option);
		});
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
	cargarNiveles();
	$("form").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		obj.empresa = 1;
		obj.fecha = darFechaActual();
		obj.activado = 0;
		obj.indicadorNuevo = 0;
		obj.fechapassword = darFechaActual();	
		postForObject(obj, "/api/users/", creacionExitosa, errorAlCrear);
	});
});
/**
 * función que se ejecuta cuando la creación es exitosa
 */
function creacionExitosa(){
	alert("Se ha creado exitosamente");
	location.reload();
}
/**
 * función que se ejecuta cuando hay un error al crear
 */
function errorAlCrear(){
	alert("Hubo un error fatal en la creación")
}