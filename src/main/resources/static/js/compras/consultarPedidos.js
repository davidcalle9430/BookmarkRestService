$(document).ready( function()
{
	iniciarFormualrio();
});


/**
 * Se encarga de inicar lo componentes del formulario
 * asociar los manejadores de eventosy llenar el 
 * dropdownlist con las Importaciones resgistradas.
 * */
function iniciarFormualrio()
{
	$( "#crear" ).click(function() 
	{
	  $( "form" ).submit( listarPedidos );
	});
	
	$( "#todos" ).click(function() 
    {  
        if( this.checked)
        {  
            $( "#pedidos" ).attr( "disabled","disabled" ); 
    		$("#pedidos").removeAttr( "required" );
    		
    		$("#fechas").attr( "style","display:block" )
    		$("#fechaInicio").attr( "required", "required" );
    		$("#fechaFin").attr( "required", "required" );
        } 
        else 
        {  
    		$("#pedidos").removeAttr("disabled");
    		$("#pedidos").attr( "required", "required" );
    		
    		$("#fechaInicio").removeAttr( "required" );
    		$("#fechaFin").removeAttr( "required" );    		
    		$("#fechas").attr("style","display:none");
        }  
    });  
	
	$.ajax({
		url : "/api/importaciones/search/obtenerImportaciones",
		success : function(data)
		{
			var importaciones = data._embedded.importaciones;
			var select = $("#pedidos");
			
			for( var i = 0; i < importaciones.length ; i++ )
			{
				var importacion = importaciones[i];
				var option = $( "<option/>", { value : importacion.ndoc, text : importacion.ndoc } );
				select.append(option);
			}
		},
		error: function(data)
		{
			alert("Error al obtener las importaciones!!!");
		}
	});
}

/**
 * Se encarga de formar la URL con los
 * parámetros necesarios para obtener 
 * las importaciones teniendo encuenta
 * si es por nDoc o un rango de fechas
 * y redirigir a la vista donde se listan
 * las importaciones resultantes.
 * */
function listarPedidos( ev )
{
	ev.preventDefault();
	var url = "listar/?";
	var tipo;
	var correcto = true;
	
	if( $( "#todos" ).prop( "checked" ))
	{
		if( Date.parse( $( "#fechaInicio" ).val( )  ) >= Date.parse( $( "#fechaFin" ).val( )  ) )
		{
			alert("La fecha fin de debe ser mayor que la fecha de inicio!!!")
			correcto = false;
		}
		else
		{
			tipo = "f";
			var fechaInicio = $( "#fechaInicio" ).val( );
			var fechaFin = $( "#fechaFin" ).val( );
			url += "tipo=" + tipo + "&fInicio=" + fechaInicio + "&fFin=" + fechaFin;
		}
	} 
	else
	{
		tipo = "n";
		var nDoc = $( "#pedidos" ).val( );
		url += "tipo=" + tipo + "&nDoc=" + nDoc;
	}
	
	if ( correcto )
	{
		location.href = url;
	}
}