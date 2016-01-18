var terminado = 0; // variable controladora de ajax

/*
 * 
 */
function actualizar(){
		var articulo = $("#articulo").val();
		var cliente = $("#cliente").val();
		getForObject({codigo : cliente, articulo : articulo}, "/api/especia/search/findOneByCodigoAndArticulo", function(articulo){
			$("#referencia").val(articulo.referencia);
			$("#precio").val(articulo.precio);
		}, function(data){
			alert("NO existe, puede seguir con la creación");
		});
}

/**
 * funciòn que se ejecuta cuando la acutalizacion es exitosa
 */
function exito(){
	alert("Actualizacion Completa");
}

/**
 * función que se ejecuta cuando hay un error
 */
function error(){
	alert("Error al crear un nuevo recurso");
}
/**
 * función encargada de cargar a los clientes en el dropdown
 */
function cargarClientes(){
	getForObject({camref:"S"}, "/api/clientes/search/especiales", function(clientes){
		var select = $("#cliente");
		clientes = clientes._embedded.clientes;
		clientes.forEach(function(cliente){
			select.append($("<option>", {value : cliente.codigo, text: cliente.razsoc}));
		});
		cargarArticulos();
	});
}



/**
 * Función encargada de cargar los artículos en el dropdown
 */
function cargarArticulos(){
	
	getForObject(null, "/api/articulos/search/especialesLinea", function(articulos){
		var select = $("#articulo");
		articulos = articulos._embedded.articulos;
		articulos.forEach(function(articulo){
			select.append($("<option>", {value : articulo.codigo, text: articulo.referencia}));
		});
		$("#cliente").val(get("codigo"));
		$("#articulo").val(get("articulo"));
		actualizar();
	});
}
/**
 * función que se ejecuta al iniciar la ejecución
 */
$(document).ready(function(){
	cargarClientes();
	$("#editar").submit(function(ev){
		ev.preventDefault();
		var obj = $(this).serializeObject();
		console.log(JSON.stringify(obj));
		postForObject(obj,"/api/especia", exito, error);
	});
	$("#eliminar").submit(function(ev){
		ev.preventDefault();
		
		deleteForObject("/api/especia/"+get("codigo")+"--"+get("articulo"), exito, error);
	});
});