var tipoOperacionSelec = new Object();
var agregarTipoOPeracion = true;

$(document).ready(function()
{
	iniciarFormulario();
});

/**
 * función encargada de llenar el formulario con los datos del tipo de operación seleccionada.
 * @param tipoOperacion: nuevoTipoOpracioneto linea seleccionado para modificar.
 */
function llenarFormulario( tipoOperacion )
{
	tipoOperacionSelec = tipoOperacion;
	
	$("#codigo").val(zeroPad(tipoOperacion.codigo, 3 ) );
	$("#nombre").val(tipoOperacion.nombre);

}

/**
 * Función encargada de obtener el siquiente código basándose en el último registradi.
 */
function cargarSiguienteCodigo (codigoActual){
	
}

/**
 * Se encarga de inicar lo compnentes del formualrio y revisar si llega el código
 * de algún objeto TipoOperacion en la URL.
  * */
function iniciarFormulario()
{
	var codTipoOperacion = get("codigo");
	if( codTipoOperacion != null && codTipoOperacion != "" )
	{
		getForObject( null,"/api/tipoOperaciones/"+codTipoOperacion, llenarFormulario );	
		agregarTipoOPeracion = false;
	}
	
	else
	{
		$.ajax({
			url : "/api/tipoOperaciones/search/obtenerMaxTipoOperacion",
			success : function(data)
					  {
						$("#codigo").val( zeroPad ( ++data, 3 ) );
					  },
			error: function(data)
					{
					}
		});
	}
	
	$("#editar").submit(editarTipoOperacion);
	$("#eliminar").submit( elminarTipoOperacion );
	
}

function editarTipoOperacion ( ev )
{
	ev.preventDefault();	
	
	tipoOperacionSelec.codigo = parseFloat( $("#codigo").val() );
	tipoOperacionSelec.nombre = $("#nombre").val().toUpperCase();
	
	if( agregarTipoOPeracion )
	{
		postForObject(tipoOperacionSelec, "/api/tipoOperaciones/", 
				function(data){alert("Se ha agregado el tipo de operación No. "+ zeroPad( data.codigo , 3) + " con éxito!");location.href = "/tipoOperacion/";},
				function(data){alert("Error al agregar el nuevo tipo de operación  No. "+ zeroPad( data.codigo , 3)+"!!");location.href = "/tipoOperacion/";} );
	}
	else
	{	
		//console.log(tipoOperacionSelec);
		$.ajax(
				{
					type : "put",
					url : "/api/tipoOperaciones/"+tipoOperacionSelec.codigo,
					data : JSON.stringify(tipoOperacionSelec),
				    contentType: 'application/json; charset=utf-8',
					success : function( data )
							{
								alert("Se ha actualizado el tipo de operación No. "+ zeroPad( data.codigo , 3) + " con éxito!");
								location.href = "/tipoOperacion/";
							},
					error   : function( data )
							{
								alert("Error al actulizar el tipo de operación No. "+ zeroPad( data.codigo , 3) + "!!");
								location.href = "/tipoOperacion/";
							} 
				}
			  );
	}
}


function elminarTipoOperacion( ev )
{
	ev.preventDefault();
	
	idOperacion = parseFloat( $("#codigo").val() );
	deleteForObject("/api/tipoOperaciones/"+idOperacion, 
			function(data){alert("Se ha eliminado el tipo de operación con éxito!");location.href = "/tipoOperacion/";},
			function(data){alert("Error al eliminar el tipo de operación!!");location.href = "/tipoOperacion/";} );
}