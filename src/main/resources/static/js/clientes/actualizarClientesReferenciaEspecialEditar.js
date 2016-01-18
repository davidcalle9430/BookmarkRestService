/**
 * 
 */
function actualizar(){
		
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
			select.append($("<option>", {value : articulo.referencia, text: articulo.referencia}));
		});
	});
}
/**
 * función que se ejecuta al iniciar la ejecución
 */
$(document).ready(function(){
	cargarClientes();
	cargarArticulos();
})