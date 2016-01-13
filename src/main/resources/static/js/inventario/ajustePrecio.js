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
				url : "/api/articulos/" + codigoSelec,
				success : function(data) {
					obtenerArticulo(data, trSelec);
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
function obtenerArticulo(articuloSelec, trSelect) 
{
	var idGenero = Math.floor(articuloSelec.codigo/1000);
	$.ajax({
		url : "/api/generos/" + idGenero,
		success : function(data) {
			$(trSelect).find("#nombre").val(data.nombre);
		},
		error : function(data) {
			alert("Este código no esta relacionado a algún género");
		}
	});
	cambiados[articuloSelec.codigo] = articuloSelec;
	$(trSelect).find("#referencia").val(articuloSelec.referencia);
	if(articuloSelec.precio != null )
	{	
		$(trSelect).find("#precio").val(articuloSelec.precio);
	}
	else
	{
		$(trSelect).find("#precio").val(0);
	}	
}

/**
 * Función encargada de crear una nueva fila con campos vacios
 * */
function agregarFila()
 {
	 var nuevoTr= $("<tr>");
	 
	 var nuevoTdCodigo= $("<td>");
	 var nuevoTdNombre= $("<td>");
	 var nuevoTdReferencia= $("<td>");
	 var nuevoTdPrecio= $("<td>");
	 var nuevoTdNprecio= $("<td>");
	 
	 var nuevoInputCodigo= $("<input>",{id:"codigo", type:"number"});
	 var nuevoInputNombre= $("<input>",{id:"nombre", type:"text", readonly:"readonly"});
	 var nuevoInputReferencia= $("<input>",{id:"referencia", type:"text",readonly:"readonly"});
	 var nuevoInputPrecio= $("<input>",{id:"precio", type:"number",readonly:"readonly"});
	 var nuevoInputNprecio= $("<input>",{id:"nPrecio", type:"number", required:"required"});
	 
	 nuevoTdCodigo.append(nuevoInputCodigo);
	 nuevoTdNombre.append(nuevoInputNombre);
	 nuevoTdReferencia.append(nuevoInputReferencia);
	 nuevoTdPrecio.append(nuevoInputPrecio);
	 nuevoTdNprecio.append(nuevoInputNprecio);
	 
	 nuevoTr.append(nuevoTdCodigo);
	 nuevoTr.append(nuevoTdNombre);
	 nuevoTr.append(nuevoTdReferencia);
	 nuevoTr.append(nuevoTdPrecio);
	 nuevoTr.append(nuevoTdNprecio);
	 
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
 * Función encargada de modificar cada articulo en la base de datos.
 * */
function actualizarArticulo( i, tr )
{
	var nCardex;
	var actualizo = false;
	if ( i > 0 )
	{
		var codidoArt = $(tr).find("#codigo").val();
		var nPrecio = $(tr).find("#nPrecio").val();
		if (nPrecio != "" && nPrecio != null && cambiados[codidoArt].precio != nPrecio )
		{
			cambiados[codidoArt].precio = nPrecio;
			putForObject(cambiados[codidoArt], "/api/articulos/"+codidoArt,
					function(data){},function(data){alert("El artículo con id "+data.codigo+" no se actualizó!!");} );
			actualizo = true;
		}
	}
	return actualizo;
}