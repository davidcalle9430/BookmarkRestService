/**
 * Se encarga de inicar lo componentes del formualrio y 
 * revisar si llegan parámetros en la URL.
 * */
function iniciarFormulario()
{
	var especial = get( "especial" );
	console.log( especial );
	
	if ( especial !== "S" )
    {
    	//lblorden.Visible = False
        //TxtOrden.Visible = False
    }
    else
    {
    	//lblorden.Visible = True
    	//TxtOrden.Visible = True
    }
}

function validarDescuento( )
{

	var descuento = $(this).val();
	if( descuento > 100 )
	{	
		alert( "El decuento no puede ser mayor a 100%" );
		$(this).val( 100 );
	}
}

function imprimir()
{
	window.close();
}