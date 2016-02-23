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
	
	$("#codigo").attr("readonly","readonly");
	$("#codigo").val(zeroPad(tipoOperacion.codigo, 3 ) );
	$("#nombre").val(tipoOperacion.nombre);

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
	
	$("form").submit(function(ev){
		ev.preventDefault();	

		var nuevoTipoOpracion = $(this).serializeObject();
		
		tipoOperacionSelec.codigo = parseInt( nuevoTipoOpracion.codigo[2] );
		tipoOperacionSelec.nombre = nuevoTipoOpracion.nombre;
		tipoOperacionSelec.tipooperacionbasesList = tipoOperacionSelec.tipooperacionbasesList;
		console.log(tipoOperacionSelec);
		if( agregarTipoOPeracion )
		{
	
			postForObject(tipoOperacionSelec, "/api/tipoOperaciones/", 
					function(data){alert("Se ha agregado el tipo de operación "+ data.nombre + " con éxito!");location.href = "/tipoOperacion/";},
					function(data){alert("Error al agregar el nuevo tipo de operación  "+ data.nombre +"!!");location.href = "/tipoOperacion/";} );
		}
		else
		{	
			putForObject(tipoOperacionSelec, "/api/tipoOperaciones/"+tipoOperacionSelec.linea, 
					function(data){alert("Se ha actualizado el tipo de operación "+ data.nombre + " con éxito!");location.href = "/tipoOperacion/";},
					function(data){alert("Error al actulizar el tipo de operación "+ data.nombre + "!!");location.href = "/tipoOperacion/";} );
		}
		
	})
}