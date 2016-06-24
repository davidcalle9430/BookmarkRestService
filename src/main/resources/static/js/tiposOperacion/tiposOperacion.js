
$(document).ready(function(){
	
	iniciarFormulario();
	
});	

/**
 * Se encarga de inicar lo compnentes del formulario.
 * */
function iniciarFormulario( ){
	
	cargarTiposOperacion( );
	
	$( "table" ).on( "click" , "tr" , clicFila );	
	
}


/**
 * Función encargada de cargar las líneas registradas en el sistema.
 */
function cargarTiposOperacion() 
{
	getForObject(null, "/api/tipoOperaciones?sort=codigo", llenarTabla );
}

/**
 * Se encarga de cargar los datos de cada línea del request ajax en una tabla HTML.
 * @paramas tiposOperacion: Las tipos de operación a cargar.
 * 
 */
function llenarTabla (tiposOperacion) 
{
	tiposOperacionAcargar = tiposOperacion._embedded.tipoOperaciones;
	var tabla = $("#tiposOperacion").first();
	for (var i = 0; i < tiposOperacionAcargar.length; i++) 
	{
		var operacion = tiposOperacionAcargar[i];
		var tr = $("<tr>");
		
		var codigo = $("<td>", {text :zeroPad(operacion.codigo, 3)});
		var nombre = $("<td>", { text : operacion.nombre });

		tr.append(codigo);
		tr.append(nombre);
		tabla.append(tr);
	}
}

/**
 * Se encarga de redirigir a la vista para editar el Tipo de Operación seleccionada.
 */
function clicFila()
{
	var hijos = $(this).children();
	location.href = "editar/?codigo="+hijos[0].innerHTML;
}
