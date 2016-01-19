var lineaSelec = new Object();
var agregarLinea = true;

$(document).ready(function()
{
	iniciarFormulario();
});

/**
 * función encargada de llenar el formulario con los datos la Linea seleccionada.
 * @param linea: nuevaLineaeto linea seleccionado para modificar.
 */
function llenarFormulario( linea )
{
	lineaSelec = linea;
	
	$("#linea").attr("readonly","readonly");
	$("#linea").val(linea.linea);
	$("#rango1").val(linea.rango1);
	$("#rango2").val(linea.rango2);
	$("#estado").val(linea.estado);
	$("#descp").val(linea.descripcion);
	$("#refEspecial").val(linea.permiterefespecial);
}

/**
 * Se encarga de inicar lo compnentes del formualrio y revisar si llega el código
 * de algún objeto Linea en la URL.
  * */
function iniciarFormulario()
{
	var codLinea = get("codigo");
	if( codLinea != null && codLinea != "" )
	{
		getForObject( null,"/api/lineas/"+codLinea, llenarFormulario );	
		agregarLinea = false;
	}
	
	$("form").submit(function(ev){
		ev.preventDefault();	
		var nuevaLinea = $(this).serializeObject();
		
		lineaSelec.linea = nuevaLinea.linea;
		lineaSelec.rango1 = nuevaLinea.rango1;
		lineaSelec.rango2 = nuevaLinea.rango2;
		lineaSelec.estado = nuevaLinea.estado.toUpperCase();
		lineaSelec.descripcion = nuevaLinea.descp;
		lineaSelec.permiterefespecial = nuevaLinea.refEspecial.toUpperCase();
		console.log(lineaSelec);
		if( agregarLinea )
		{
			postForObject(lineaSelec, "/api/lineas/", 
					function(data){alert("Se ha agregado la línea "+ data.linea + " con éxito!");location.href = "/mnuactlajm/";},
					function(data){alert("Error al agregar la nueva línea "+ data.linea +"!!");location.href = "/mnuactlajm/";} );
		}
		else
		{	
			putForObject(lineaSelec, "/api/lineas/"+lineaSelec.linea, 
					function(data){alert("Se ha actualizado la línea "+ data.linea + " con éxito!");location.href = "/mnuactlajm/";},
					function(data){alert("Error al actulizar la línea "+ data.linea +"!!");location.href = "/mnuactlajm/";} );
		}
	})
}