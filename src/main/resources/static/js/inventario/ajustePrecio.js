var cambiados = new Object();

$(document).ready(
function() 
{ 
	obtenerFilaSelec();
	$("form").submit(guardarCambios);
});


/**
 * Se encarga de obtener el objeto articulo asocaido al codigo ingresado 
 * teniendo en cuenta que fila se esta modificando.
 * */
function obtenerFilaSelec()
{
	$("table").on("change", "input[id=codigo]", 
	function(ev) 
	{
		var trSelec = $(this).parent().parent();
		var codigoConFormato = $(trSelec).find("#codigo").val();
		$(trSelec).find("#nombre").val("");
		$(trSelec).find("#referencia").val("");
		$(trSelec).find("#precio").val("");
		$(trSelec).find("#nPrecio").val("");
		if( verificarFormatoCodigo( codigoConFormato ) )
		{
			var codigoSelec = obtenerNumeroAPartirDeCodigo(codigoConFormato);
			if( obtenerCheckSum( codigoSelec ) == darCheckSumDeCodigo( codigoConFormato ) )
			{
				$.ajax
				({
					url : "/api/articulos/" + codigoSelec,
					success : function(data) 
					{
						obtenerArticulo(data, trSelec);
					},
					error : function(data) 
					{
						alert("Este código no esta relacionado a algún articulo");
					}
				});
			}
			else
			{
				alert("El dígito de verificación es incorrecto!!");
			}
		}
		else
		{
			alert("Este código no coincide con el formato: 000-000-0");
			$(trSelec).find("#codigo").val("000-000-0");
		}
	});
}

/**
 * Se encarga de obtener el objeto género asocaido al codigo ingresado y al artículo que se esta modificando.
 * Luego autocompleta los demás atributos del artículo.
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
	 
	 var nuevoInputCodigo= $("<input>",{id:"codigo", type:"text"});
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
	var actualizo = false;
	if ( i > 0 )
	{
		var codidoArt = $(tr).find("#codigo").val();
		var nPrecio = $(tr).find("#nPrecio").val();
		if( verificarFormatoCodigo( codidoArt ) )
		{
			var codigoSelec = obtenerNumeroAPartirDeCodigo(codidoArt);
			if (nPrecio != "" && nPrecio != null && cambiados[codigoSelec].precio != nPrecio )
			{
				cambiados[codigoSelec].precio = nPrecio;
				putForObject(cambiados[codigoSelec], "/api/articulos/"+codigoSelec,
						function(data){},function(data){alert("El artículo con id "+data.codigo+" no se actualizó!!");} );
				actualizo = true;
			}
		}
		else
		{
			alert("El código de alguno de los artículos no coincide con el formato: 000-000-0");
			$(tr).find("#codigo").val("000-000-0");
		}
	}
	return actualizo;
}