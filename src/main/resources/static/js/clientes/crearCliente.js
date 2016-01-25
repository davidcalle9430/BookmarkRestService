/**
 * Función que se carga cuando el cliente está listo, se seleccciona como límite de ciudades 1000
 */
$(document).ready(function()
{
	cargarValores();
	var formulario = $("form").first();
	formulario.submit(crearClienteBoton);	
});

