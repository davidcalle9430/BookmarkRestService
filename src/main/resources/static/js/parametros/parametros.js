var nfact = null; // la nfact a actualizae
var usuario = null; // el usuario autenticado
var terminal = "por definir"; // el terminal siempre es por definir
/**
 * funcion que se ejecuta cuando carga el dom
 */
$(document).ready(function(){
	getForObject(null, "/api/seguridad/autenticacion/", function(usuar){
		usuario = usuar;
	});
	inicializaNfact();
	$("form").submit(function(ev){
		ev.preventDefault();
		var anterior = JSON.parse(JSON.stringify(nfact));
		anterior.usuario = usuario.usuario;
		anterior.fecha = darFechaActual();
		anterior.terminal = terminal;
		anterior.registro = "anterior";
		var obj = $(this).serializeObject();
		for (var property in obj) {
			nfact[property] = obj[property];
		}
		var nuevo = JSON.parse(JSON.stringify(nfact));
		delete nuevo.id;
		delete anterior.id;
		nuevo.fecha = darFechaActual();
		nuevo.terminal = terminal;
		nuevo.registro = "nuevo";
		nuevo.usuario = usuario.usuario;
		putForObject(nfact, "/api/nfact/1", exitoNfact, errorNfact);
		postForObject(anterior, "/api/nfactlog", exitoLog,  errorLog);
		postForObject(nuevo, "/api/nfactlog", exitoLog,  errorLog);

	});
});
/**
 * función de exito de actualizar log
 */
function exitoLog(){
	console.log(" bien al actualizar");
}

/**
 * función de error de actualizar log
 */
function errorLog(){
	console.log("error bien");
}
/**
 * Función de error al acutalizar nfact
 */
function errorNfact(){
	alert("Error al actualizar NFACT");
}
/**
 * función de  exito al actualizar
 */
function exitoNfact(){
	alert("Actualizado Correctamente");
}
/**
 * función que inicializa con los valores acutales el formualario
 */
function inicializaNfact(){
	getForObject(null, "/api/nfact/1", function(fact){
		nfact = fact;
		$("#factiva").val(fact.factiva);
		$("#clavec").val(fact.clavec);
		$("#iva").val(fact.iva);
		$("#cuenta1").val(fact.cuenta1);
		$("#cuenta2").val(fact.cuenta2);
		$("#recibocaja").val(fact.recibocaja);
		$("#nc").val(fact.nc);
		$("#nd").val(fact.nd);
		$("#factPROVEEDORES").val(fact.factPROVEEDORES);
		$("#nuevoformato").val(fact.nuevoformato);
		$("#aaaaseguimiento").val(fact.aaaaseguimiento);
		$("#facturaEnproceso").val(fact.facturaEnproceso);
		
	})
}