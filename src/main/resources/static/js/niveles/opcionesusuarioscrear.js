var opciones = null; // todaas las opciones
var niveles = null; // todos los niveles
var usuario = null; // usuario que está logeado
/**
 * función que se ejecuta al cargar el DOM
 */
$(document).ready(function() {
	getForObject(null, "/api/seguridad/autenticacion/", function(actual) {
		usuario = actual;
	});
	$("form").submit(function(ev) {
		ev.preventDefault();
		var obj = $(this).serializeObject();
		console.log(obj);
		var nuevo = new Object();
		nuevo.empresa = 1;
		nuevo.rol = parseInt(obj.nivel);
		nuevo.menu = obj.menu;
		nuevo.fecha = darFechaActual();
		nuevo.usuario = usuario.usuario;
		console.log(JSON.stringify(nuevo));	
		postForObject( obj	 , "/api/rolesymenus/", exito , error);
	});
	cargarFormulario();
});
/**
 * función que carga todos los elementos que encesita un formulario
 */
function cargarFormulario(){
	getForObject({size:99999}, "/api/niveles", cargarNiveles , errorNiveles);
	getForObject({size:99999}, "/api/menuses", cargarMenus , errorMenus);
}



/**
 * función que se encarga de cargar el dropdown de menus
 * @param data, representan los menus a cargar
 */
function cargarMenus(data){
	menus = data._embedded .menuses;
	var listaMenus = $("#menu");
	menus.forEach(function(menu){
		var nuevoMenu = $("<option>", { text: menu.menusPK.menu + " - " + menu.descripcion , value : menu.menusPK.menu  });
		listaMenus.append(nuevoMenu);
	});
}
/**
 * función que se ejecuta cuando hay un error al cargar los mebus
 */
function errorMenus(){
	alert("Error al cargar los niveles");
}

/**
 * función que se encarga de cargar el dropdown de niveles
 * @param data, representan los niveles a cargar
 */
function cargarNiveles(data){
	niveles = data._embedded .niveles;
	var listaNiveles = $("#nivel");
	niveles.forEach(function(nivel){
		var nuevoNivel = $("<option>", { text:nivel.descripcion , value : nivel.nivelesPK.nivel });
		listaNiveles.append(nuevoNivel);
	});
	
}
/**
 * función que se ejecuta cuando hay un error al cargar los niveles
 */
function errorNiveles(){
	alert("Error al cargar los niveles");
}
/**
 * función que se ejecuta cuando hay exito
 */
function exito(){
	alert("Éxito al crear");
	//location.href = "/jm/";
}
/**
 * función que se ejecuta cuando hay error
 */
function error(){
	alert("Error al crear");
	//location.href = "/jm/";
}