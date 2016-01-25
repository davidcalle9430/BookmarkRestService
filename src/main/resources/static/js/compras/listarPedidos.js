$(document).ready(
function() 
{ 
	iniciarFormulario();
});

/**
 * Se encarga de inicar lo componentes del formulario, 
 * revisar e interpretar los parámenuevaFilaos que llegan en la URL.
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
	}
	else
	{
		nDoc = get("nDoc");
		var fechaActual = darFechaActual( ).split("/");;
		fechaInicio = fechaActual[2]+"-01-01";
		fechaFin = formatearFechaISO( darFechaActual( ) );
	}	
	
	obtenerPedidos( nDoc, fechaInicio, fechaFin );
}


/**
 * Se encarga de inicar lo componentes del formulario, 
 * revisar e interpretar los parámenuevaFilaos que llegan en la URL.
 * */
function obtenerPedidos( nDoc, fechaInicio, fechaFin )
{
	var params = { nDoc:nDoc, fechaInicio: fechaInicio, fechaFin: fechaFin};

	$.ajax(
	{
		url : "/api/obtenerPedidos/",
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
 * Se encarga diligenciar la tabla HTML con los pedidos
 * solicitados por el usuario, formateando la fecha como se pide.
 * También de calcular el total de costos, ventas, y utilidades.
 * */
function llenarTabla( pedidos )
{
	var columnaFecha;
	var columnaNdoc;
	var columnaCosto;
	var columnaVenta
	var columnaUtilidad;
	var nuevaFila;
	
	var totalVentas = 0;
	var totalCosto = 0;
	var totalUtilidad = 0;
	var fechaConFormato;
	var dia;
	var mes;

	for (var i = 0; i < pedidos.length; i++) 
	{
		totalCosto += pedidos[i].costo;
		totalVentas += pedidos[i].venta;
		
		fechaConFormato = new Date( pedidos[i].fecha );
		dia = zeroPad( fechaConFormato.getDate(), 2 );
		mes = zeroPad( fechaConFormato.getMonth() + 1, 2 );
		
		columnaFecha = $('<td>', {
		text : dia+"/"+mes+"/"+fechaConFormato.getFullYear()
		});
		
		columnaNdoc = $('<td>', {
			text : pedidos[i].nDoc
		});
		
		columnaCosto = $('<td>', {
			text : pedidos[i].costo
		});
		
		columnaVenta = $('<td>', {
			text : pedidos[i].venta
		});
		
		columnaUtilidad = $('<td>', {
			text : pedidos[i].utilidad
		});
		
		nuevaFila = $('<tr>');
		
		nuevaFila.append(columnaFecha);
		nuevaFila.append(columnaNdoc);
		nuevaFila.append(columnaCosto);
		nuevaFila.append(columnaVenta);
		nuevaFila.append(columnaUtilidad);
		
		$("table").append(nuevaFila);
	}
	
	totalUtilidad = ( ( ( totalCosto / totalVentas ) - 1 ) * 100 ) * ( -1 );
	
	$("#pedidos").val( pedidos.length );
	$("#costo").val( totalCosto );
	$("#venta").val( totalVentas);
	$("#utilidad").val( totalUtilidad );
}