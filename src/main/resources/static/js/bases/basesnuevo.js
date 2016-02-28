function error(data){
	alert("Error al cargar los tipos de operación");
}
/**
 * función que carga el dropdown de los tipos de operación
 */
function cargarTiposOperacion(){
	getForObject({size:9999},"/api/tipoOperaciones", function(tipos){
		tipos = tipos._embedded.tipoOperaciones;
		var select = $("#tipooperacion1");
		tipos.forEach(function(tipo){
			var option = $("<option>",{text: tipo.nombre, value:tipo.codigo});
			select.append(option);
		});
	}, error)
}

/**
 * función que se ejecuta cuando carga el DOM
 */
$(document).ready(function(){
	cargarTiposOperacion();
	$("form").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		obj.tipooperacionbasesPK = new Object();
		obj.tipooperacionbasesPK.tipooperacion = obj.tipooperacion1;
		obj.tipooperacionbasesPK.impuesto = obj.impuesto;
		obj.tipooperacion1 = "/api/tipoOperaciones/" + obj.tipooperacion1;
		console.log(JSON.stringify(obj));
		postForObject(obj, "/api/tipoOperacionBases", creacionExitosa, errorAlCrear);
	});
});
/**
 * función que muestra el mensaje cuando la creación es exitosa
 */
function creacionExitosa(){
	alert("Se ha creado exitosamente");
	location.reload();
}
/**
 * función que muestra un mensaje cuando hay un fallo en la creación
 */
function errorAlCrear(){
	alert("Hubo un error fatal en la creación")
}