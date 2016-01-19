/**
 * Mapa donde se guardan los artículos que el usuario desea actualizar.
 * Llave: Código del artículo.
 * Valor: Objeto artículo
 * */
var cambiados = new Object();

$(document).ready(function() { obtenerFilaSelec();
$("form").submit(guardarCambios);
});

/**
 * Función encargada de crear una nueva fila con campos vacios
 * */
function agregarFila()
 {
	 var nuevaFila= $("<tr>");
	 
	 var columnaCodigo= $("<td>");
	 var columnaNombre= $("<td>");
	 var columnaCantidadVieja= $("<td>");
	 var columnaCantNueva= $("<td>");
	 var columnaDocumento= $("<td>");
	 var columnaNdoc= $("<td>");
	 
	 var valorColumnaCodigo= $("<input>",{id:"codigo", type:"number"});
	 var valorColumnaNombre= $("<input>",{id:"nombre", type:"text"});
	 var valorColumnaCantidadVieja= $("<input>",{id:"cantidadVieja", type:"text",readonly:"readonly"});
	 var valorColumnaCantNueva= $("<input>",{id:"cantNueva", type:"number",required:"required"});
	 var valorColumnaDocumento= $("<input>",{id:"documento", type:"text", required:"required", maxlength:"3"});
	 var valorColumnaNdoc= $("<input>",{id:"ndoc", type:"number", required:"required"});
	 
	 columnaCodigo.append(valorColumnaCodigo);
	 columnaNombre.append(valorColumnaNombre);
	 columnaCantidadVieja.append(valorColumnaCantidadVieja);
	 columnaCantNueva.append(valorColumnaCantNueva);
	 columnaDocumento.append(valorColumnaDocumento);
	 columnaNdoc.append(valorColumnaNdoc);
	 
	 nuevaFila.append(columnaCodigo);
	 nuevaFila.append(columnaNombre);
	 nuevaFila.append(columnaCantidadVieja);
	 nuevaFila.append(columnaCantNueva);
	 nuevaFila.append(columnaDocumento);
	 nuevaFila.append(columnaNdoc);
	 
	 $("table").append(nuevaFila);
 }

/**
 * Función encargada de crear un nuebo objeto Cardex.
 * @param articulo: Articulo asociado al nuevo objeto Cardex.
 * @param nCantidad: Cantidad que entra/sale del registro Cardex
 * @param tr: Fila HTML donde se encuentra el artículo al que se le actualizará, 
 * 			  en la base de datos, la cantidad.
 * */
function crearCardex( articulo, nCantidad, tr )
{
	var nCardex = new Object();
	var tipoAjuste;
	var ajuste = nCantidad - articulo.cantdisp;
	var doc = $(tr).find("#documento").val().toUpperCase();
	var nDoc = $(tr).find("#ndoc").val();
	
	if (ajuste > 0)
	{
		tipoAjuste = "E";
	}
	else
	{
		tipoAjuste = "S";
	}	
	
	if ( ajuste < 0 )
	{	
		ajuste = ajuste * -1
	}
	nCardex.codigo = articulo.codigo;
	nCardex.fecha = darFechaActual();
	nCardex.tipo = tipoAjuste;
	nCardex.documento =  doc;
	nCardex.cantidad = ajuste;
	nCardex.ndoc = nDoc;
	nCardex.saldo = nCantidad;
	
	return nCardex;
}

/**
 * Se encarga de capturar la fila cuya columna "Código" se esta modificando.
 * Para así obtener el artículo que se modificará.
 * */
function obtenerFilaSelec()
{
	$("table").on("keyup", "input[id=codigo]", function(ev) {
		var trSelec = $(this).parent().parent();
		var codigoSelec = $(trSelec).find("#codigo").val();
		$(trSelec).find("#nombre").val("");
		$(trSelec).find("#cantidadVieja").val("");
		$(trSelec).find("#cantNueva").val("");
		$(trSelec).find("#documento").val("");
		$(trSelec).find("#ndoc").val("");
		$.ajax({
				url : "/api/generos/" + codigoSelec,
				success : function(data) {
					obtenerAjuste(data, trSelec);
				},
				error : function(data) {
					alert("Este código no esta relacionado a algún artículo");
				}
			});
	});
}

/**
 * Función encargada de obtener el objeto articulo asocaido al codigo digitado.
 * @param articuloSelec: Articulo seleccionado.
 * @param trSelect: Fila HTML donde se encuentra el artículo que se modificará.
 * */
function obtenerAjuste(articuloSelec, trSelect) 
{
	cambiados[articuloSelec.codigo] = articuloSelec;
	$(trSelect).find("#nombre").val(articuloSelec.nombre);
	$(trSelect).find("#cantidadVieja").val(articuloSelec.cantdisp);
}

/**
 * Función encargada de modificar la cantidad de un artículo en la base de datos.
 * También de crear un nuevo registro en la tabla Cardex.
 * @param i: Índice de la fila donde se encuentra el artículo a modificiar. Sirve para controlar 
 * 			 que la fila en @tr que se recibe no sea el encabezado de la tabla.
 * @param tr: Fila HTML donde se encuentra el artículo al que se le actualizará, 
 * 			  en la base de datos, la cantidad.
 * */
function actualizarArticulo( i, tr )
{
	var nCardex;
	var actualizo = false;
	if ( i > 0 )
	{
		var codidoArt = $(tr).find("#codigo").val();
		var nCantidad = $(tr).find("#cantNueva").val();
		if (nCantidad != "" && nCantidad != null && cambiados[codidoArt].cantdisp != nCantidad )
		{
			
			nCardex = crearCardex( cambiados[codidoArt], nCantidad, tr );
			cambiados[codidoArt].cantdisp = nCantidad;
			putForObject(cambiados[codidoArt], "/api/generos/"+codidoArt,
					function(data){},function(data){alert("El artículo con id "+data.codigo+" no se actualizó!!");} );
			postForObject(nCardex, "/api/cardexi/", 
					function(data){},function(data){alert("Error al agregar un nuevo registro a la hoja Cardex!!");} );
			actualizo = true;
		}
	}
	return actualizo;
}

/**
 * Función encargada de recorrer la tabla que contiene los artículos a los
 * que el usuario ha decidio cambiarles la cantidad, para luego delegar la función
 * de actualizarlos en la base de datos.
 * @param ev: Evento, asociado al clic del ratón, que se dispara cuando el 
 * 			  usuario decide persistir los cambios hechos.
 * */
function guardarCambios(ev)
{		
	ev.preventDefault();
	var actualizados = 0;
	$("table tr").each(function(i,tr){
		if (actualizarArticulo(i, $(tr)))
		{
			actualizados++;
		}
	});
	if ( actualizados > 0 )
	{
		alert("Se han actualizado exitósamente los "+actualizados+" artículos!");
	}
	else
	{
		alert("No se registró algún cambio!");
	}
	location.reload();
}