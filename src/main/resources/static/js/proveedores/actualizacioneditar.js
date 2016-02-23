var proveedorACambiar = null; // ariable que guarda los datos del proveedor a acambiar
/**
 * función que carga le dropdown de ciudades
 */
function cargarCiudades(idProveedor){
	getForObject({size:9999}, "/api/ciudades", function(ciudades){
		ciudades = ciudades._embedded.ciudades;
		var select = $("#ciudad");
		ciudades.forEach(function(ciudad){
			var option = $("<option>", {text: ciudad.ciudad, value : ciudad.codigo});
			select.append(option);
		});
		cargarProveedor(idProveedor);
	}, error);
}
/**
 * función que carga la infromación del proveedor por el que se recibe por parámetro
 * @param idProveedor
 */
function cargarProveedor(idProveedor){
	getForObject({projection: "ciudad"},"/api/proveedores/"+idProveedor, function(proveedor){
		proveedorACambiar = proveedor;
		$("#identificacion").val(proveedor.identificacion);
		$("#nombre").val(proveedor.nombre);
		$("#direccion").val(proveedor.direccion);
		$("#telefono").val(proveedor.telefono);
		$("#ciudad").val(proveedor.ciudad.codigo);
	},error);
}
function error(data){
	alert("El proveedor ya no existe");
	window.location = "../";
}
/**
 * arichivo capturador de eventos del html
 */
$(document).ready(function(){
	var idProveedor = get("proveedor");
	cargarCiudades(idProveedor);
	// submit de editar
	$("#editar").submit(function(ev){
		ev.preventDefault();
		delete proveedorACambiar._links; // esto es necesario para que no modifique un valor que no se debe en el api
		delete proveedorACambiar.ciudad;
		editado = $(this).serializeObject();
		console.log(editado);
		editado.ciudad = "/api/ciudades/" + editado.ciudad;
		for (var property in editado) {
			   proveedorACambiar[property] = editado[property]; 
		}
		console.log(proveedorACambiar);
		putForObject(proveedorACambiar, "/api/proveedores/"+idProveedor, exitoActualizacion, errorActualizar )
	});
	
	//submit del elimnar
	$("#eliminar").submit(function(ev){
		ev.preventDefault();
		var confirm = window.confirm("Seguro que desea eliminar");
		if(confirm){
			deleteForObject("/api/proveedores/"+idProveedor, exitoBorrado, errorBorrado);
		}
	})
});
/**
 * función que se ejecuta después de un exito en la actulización
 * @returns 
 */
function exitoActualizacion(){
	alert("Actualización terminada");
}
/**
 * funcion que se ejecuta cuando hay un error en la actualización
 */
function errorActualizar(){
	alert("No se pudo actualizar la zona");
}

/**
 * función que se ejecuta después de un exito en la actulización
 * @returns 
 */
function exitoBorrado(){
	alert("Actualización terminada");
}
/**
 * funcion que se ejecuta cuando hay un error en la actualización
 */
function errorBorrado(){
	alert("No se pudo actualizar la zona");
}

