$(document).ready(
function() 
{ 
	iniciarFormulario();
});

/**
 * Se encarga de inicar lo componentes del formulario, 
 * revisar e interpretar los parámetros que llegan en la URL.
 * */
function iniciarFormulario()
{
	var tipoConsulta = get("tipo");
	var nDoc = null;
	var  fechaInicio;
	var fechaFin;
	if( tipoConsulta === "f" )
	{
		fechaInicio = get("fInicio");
		fechaFin = get("fFin");
		alert("ECHAAA");
	}
	else
	{
		alert("NDOC");
		nDoc = get("nDoc");
		var fechaActual = darFechaActual( ).split("/");;
		fechaInicio = fechaActual[2]+"-01-01";
		fechaFin = formatearFechaISO( darFechaActual( ) );
	}	
	obtenerImportaciones( nDoc, fechaInicio, fechaFin );
}


/**
 * Se encarga de inicar lo componentes del formulario, 
 * revisar e interpretar los parámetros que llegan en la URL.
 * */
function obtenerImportaciones( nDoc, fechaInicio, fechaFin )
{
	var params = { nDoc:nDoc, fechaInicio: fechaInicio, fechaFin: fechaFin};
	console.log(params);
	$.ajax(
	{
		url : "/api/obtenerImportaciones/",
		type: "put",
		data: JSON.stringify( params ),
	    contentType: 'application/json; charset=utf-8',
	    success: function( data )
	    {
	    	llenarTabla( data );
	    },
	    error: function( data )
	    {
	    	alert("Error al obtener las importaciones!!");
	    }
	});

}

/**
 * Se encarga de inicar lo componentes del formulario, 
 * revisar e interpretar los parámetros que llegan en la URL.
 * */
function llenarTabla( importaciones )
{
	console.log( importaciones );
}