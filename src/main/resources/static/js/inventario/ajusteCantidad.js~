var cambiados = new Object();

$(document).ready(function() { obtenerFilaSelec();
$("form").submit(guardarCambios);
});


/**
 * Función encargada de obtener la fila donde se digita el cádigo del articulo a actualizar
 * */
function obtenerFilaSelec()
{
	$("table").on("change", "input[id=codigo]", function(ev) {
		var trSelec = $(this).parent().parent();
		var codigoSelec = $(trSelec).find("#codigo").val();
		$.ajax({
				url : "/api/generos/" + codigoSelec,
				success : function(data) {
					obtenerAjuste(data, trSelec);
				},
				error : function(data) {
					alert("Este código no esta relacionado a algún articulo");
				}
			});
	});
}

/**
 * Función encargada de obtener el objeto articulo asocaido al codigo digitado
 * @param articuloSelec: Articulo seleccionado.
 * @param trSelect: Fila HTML seleccionada.
 * */
function obtenerAjuste(articuloSelec, trSelect) 
{
	cambiados[articuloSelec.codigo] = articuloSelec;
	$(trSelect).find("#nombre").val(articuloSelec.nombre);
	$(trSelect).find("#cantidadVieja").val(articuloSelec.cantdisp);
}

/**
 * Función encargada de crear una nueva fila con campos vacios
 * */
function agregarFila()
 {
	 var nuevoTr= $("<tr>");
	 
	 var nuevoTdCodigo= $("<td>");
	 var nuevoTdNombre= $("<td>");
	 var nuevoTdCantidadVieja= $("<td>");
	 var nuevoTdCantNueva= $("<td>");
	 var nuevoTdDocumento= $("<td>");
	 var nuevoTdNdoc= $("<td>");
	 
	 var nuevoInputCodigo= $("<input>",{id:"codigo", type:"number"});
	 var nuevoInputNombre= $("<input>",{id:"nombre", type:"text"});
	 var nuevoInputCantidadVieja= $("<input>",{id:"cantidadVieja", type:"text",readonly:"readonly"});
	 var nuevoInputCantNueva= $("<input>",{id:"cantNueva", type:"number",required:"required"});
	 var nuevoInputDocumento= $("<input>",{id:"documento", type:"text", required:"required", maxlength:"3"});
	 var nuevoInputNdoc= $("<input>",{id:"ndoc", type:"number", required:"required"});
	 
	 nuevoTdCodigo.append(nuevoInputCodigo);
	 nuevoTdNombre.append(nuevoInputNombre);
	 nuevoTdCantidadVieja.append(nuevoInputCantidadVieja);
	 nuevoTdCantNueva.append(nuevoInputCantNueva);
	 nuevoTdDocumento.append(nuevoInputDocumento);
	 nuevoTdNdoc.append(nuevoInputNdoc);
	 
	 nuevoTr.append(nuevoTdCodigo);
	 nuevoTr.append(nuevoTdNombre);
	 nuevoTr.append(nuevoTdCantidadVieja);
	 nuevoTr.append(nuevoTdCantNueva);
	 nuevoTr.append(nuevoTdDocumento);
	 nuevoTr.append(nuevoTdNdoc);
	 
	 $("table").append(nuevoTr);
 }

/**
 * Función encargada de actualizar las cantidades de cada articulo modificado
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

/**
 * Función encargada de modificar cada articulo en la base de datos y también de crear un nuevo registro de la entidad Cardex.
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
			postForObject(nCardex, "/api/cardexi", 
					function(data){},function(data){alert("Error al agregar un nuevo registro a la hoja Cardex!!");} );
			actualizo = true;
		}
	}
	return actualizo;
}

function crearCardex( articulo, nCantidad, tr )
{
	var nCardex = new Object();
	var tipoAjuste;
	var ajuste = nCantidad - articulo.cantdisp;
	var doc = $(tr).find("#documento").val();
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