var base = null;

function error(data){
	alert("Error al cargar los tipos de operación");
	window.location.href="/jm/";
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
		cargarBase();
	}, error)
}

function cargarBase(){
	var tipo = get("base");
	getForObject( {projection : "tipo"} , "/api/tipoOperacionBases/"+tipo , function(nBase){
		base = nBase;
		console.log(base);
		console.log(base.tipooperacionbasesPK.impuesto)
		$("#tipooperacion1").val(base.tipooperacion1.codigo);
		$("#"+base.tipooperacionbasesPK.impuesto).prop("checked", true);
		$("#base").val(base.base);
		$("#porcentaje").val(base.porcentaje);
		$("#"+base.tipo).prop("checked",true);
	}, error);
}
/**
 * función que se ejecuta cuando carga el DOM
 */
$(document).ready(function(){
	cargarTiposOperacion();
	$("#editar").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		obj.tipooperacionbasesPK = new Object();
		obj.tipooperacionbasesPK.tipooperacion = obj.tipooperacion1;
		obj.tipooperacionbasesPK.impuesto = obj.impuesto;
		obj.tipooperacion1 = "/api/tipoOperaciones/" + obj.tipooperacion1;
		console.log(JSON.stringify(obj));
		putForObject(obj, "/api/tipoOperacionBases/"+get("base"), creacionExitosa, errorAlCrear);
	});
	
	$("#eliminar").submit(function(ev){
		ev.preventDefault();
		var confirm = window.confirm("Seguro que desea eliminar");
		if(confirm){
			deleteForObject("/api/tipoOperacionBases/"+get("base"), exitoBorrado, errorBorrado);
		}
	})
});
/**
 * función que muestra el mensaje cuando la creación es exitosa
 */
function creacionExitosa(){
	alert("Se ha editado exitosamente");
	location.reload();
}
/**
 * función que muestra un mensaje cuando hay un fallo en la creación
 */
function errorAlCrear(){
	alert("Hubo un error fatal en la creación")
}

/**
 * función que muestra el mensaje cuando la creación es exitosa
 */
function exitoBorrado(){
	alert("Se ha borrado exitosamente");
	location.reload();
}
/**
 * función que muestra un mensaje cuando hay un fallo en la creación
 */
function errorBorrado(){
	alert("Hubo un error fatal en el borrado")
}