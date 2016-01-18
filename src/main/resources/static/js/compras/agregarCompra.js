/**
 * Mapa donde se guardan los artículos que el usuario desea comprar.
 * Llave: Código del artículo.
 * Valor: Objeto artículo
 * */
var comprados = new Object();

$(document).ready(
function() 
{ 
	iniciarFormulario();
});

/**
 * Se encarga de inicar lo compnentes del formualrio y revisar si llega el código
 * de algún artculo en la URL.
 * */
function iniciarFormulario()
{
	obtenerFilaSelec();
	/*var getCodigo = get("codigo");
	if( getCodigo != null && getCodigo != "")
	{
		var celda = $("#codigo");
		celda.val(getCodigo);
		var trSelec = $(celda).parent().parent();
		celda.attr("readonly","readonly");
		$("#botAgregaFila").attr("style","display:none");	
		obtenerAtributosArticulo(trSelec);
	}*/
	$("form").submit(comprar);	
}

/**
 * Función encargada de crear una nueva fila con campos vacios.
 * */
function agregarFila()
 {
	 var nuevaFila= $("<tr>");
	 
	 var columnaCodigo= $("<td>");
	 var columnaNombre= $("<td>");
	 var columnaReferencia= $("<td>");
	 var columnaCantidad= $("<td>");
	 var columnaCostoJm= $("<td>");
	 var columnaCostoIm= $("<td>");
	 var columnaDoc= $("<td>");
	 var columnaNdoc= $("<td>");
	 var columnaPrecio= $("<td>");


	 var valorColumnaCodigo= $("<input>",{id:"codigo", type:"text"});
	 var valorColumnaNombre= $("<input>",{id:"nombre", type:"text", readonly:"readonly"});
	 var valorColumnaReferencia= $("<input>",{id:"referencia", type:"text",readonly:"readonly"});
	 var valorColumnaCantidad= $("<input>",{id:"cantidad", type:"number", required:"required"});
	 var valorColumnaCostoJm= $("<input>",{id:"costoJm", type:"number", required:"required"});
	 var valorColumnaCostoIm= $("<input>",{id:"costoIm", type:"number", required:"required"});
	 var valorColumnaDoc= $("<input>",{id:"doc", type:"text", required:"required"});
	 var valorColumnaNdoc= $("<input>",{id:"nDoc", type:"number", required:"required"});
	 var valorColumnaPrecio= $("<input>",{id:"precio", type:"number"/*,readonly:"readonly"*/});

	 columnaCodigo.append(valorColumnaCodigo);
	 columnaNombre.append(valorColumnaNombre);
	 columnaReferencia.append(valorColumnaReferencia);
	 columnaCantidad.append(valorColumnaCantidad);
	 columnaCostoJm.append(valorColumnaCostoJm);
	 columnaCostoIm.append(valorColumnaCostoIm);
	 columnaDoc.append(valorColumnaDoc);
	 columnaNdoc.append(valorColumnaNdoc);
	 columnaPrecio.append(valorColumnaPrecio);
	 
	 nuevaFila.append(columnaCodigo);
	 nuevaFila.append(columnaNombre);
	 nuevaFila.append(columnaReferencia);
	 nuevaFila.append(columnaCantidad);
	 nuevaFila.append(columnaCostoJm);
	 nuevaFila.append(columnaCostoIm);
	 nuevaFila.append(columnaDoc);
	 nuevaFila.append(columnaNdoc);
	 nuevaFila.append(columnaPrecio);
	 
	 $("table").append(nuevaFila);
 }

/**
 * Se encarga de capturar la fila cuya columna "Código" se esta modificando.
 * Para así obtener el artículo que se comprará.
 * */
function obtenerFilaSelec()
{
	$("table").on("change", "input[id=codigo]", 
	function(ev) 
	{
		var trSelec = $(this).parent().parent();
		obtenerAtributosArticulo(trSelec);
	});
}

/**
 * Se encarga de obtener el objeto articulo asocaido al codigo ingresado.
 * teniendo en cuenta que fila se esta modificando.
 * @param trSelec: Fila HTML donde se encuentra el artículo que se comprará.
 * */
function obtenerAtributosArticulo( trSelec)
{
	var codigoConFormato = $(trSelec).find("#codigo").val();
	$(trSelec).find("#nombre").val("");
	$(trSelec).find("#referencia").val("");
	$(trSelec).find("#cantidad").val("");
	$(trSelec).find("#costoJm").val("");
	$(trSelec).find("#costoIm").val("");
	$(trSelec).find("#doc").val("");
	$(trSelec).find("#nDoc").val("");
	$(trSelec).find("#precio").val("");
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
					obtenerGenero(data, trSelec);
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
}

/**
 * Se encarga de obtener el objeto género asocaido al codigo ingresado del artículo 
 * que se esta modificando. Luego autocompleta, en el formulario los demás atributos del artículo.
 * @param articuloSelec: Articulo seleccionado.
 * @param trSelect: Fila HTML donde se encuentra el artículo que se comprará.
 * */
function obtenerGenero(articuloSelec, trSelect) 
{
	var idGenero = Math.floor(articuloSelec.codigo/1000);
	$.ajax({
		url : "/api/generos/" + idGenero,
		success : function(data) 
		{
			$(trSelect).find("#nombre").val(data.nombre);
		},
		error : function(data) 
		{
			alert("Este artículo no esta relacionado a algún género");
		}
	});
	comprados[articuloSelec.codigo] = articuloSelec;
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
 * Función encargada de recorrer la tabla que contiene los artículos a los
 * que el usuario ha decidio cambiarles el precio, para luego delegar la función
 * de actualizarlos en la base de datos.
 * @param ev: Evento, asociado al clic del ratón, que se dispara cuando el 
 * 			  usuario decide persistir los cambios hechos.
 * */
function comprar(ev)
{		
	ev.preventDefault();
	var comprados = 0;
	$("table tr").each(function(i,tr){
		if (actualizarArticulo(i, $(tr)))
		{
			comprados++;
		}
	});
	if ( comprados > 0 )
	{
		alert("Se han agregado exitósamente los "+comprados+" artículos aquiridos!");
	}
	else
	{
		alert("No se registró alguna compra!");
	}
	location.reload();
}

/**
 * Función encargada de modificar el precio de un artículo en la base de datos.
 * @param i: Índice de la fila donde se encuentra el artículo a modificiar. Sirve para controlar 
 * 			 que la fila en @tr que se recibe no sea el encabezado de la tabla.
 * @param tr: Fila HTML donde se encuentra el artículo al que se le actualizará, 
 * 			  en la base de datos, el precio.
 * */
function actualizarArticulo( i, tr )
{
	var actualizo = false;
	if ( i > 0 )
	{
		var codidoArt = $(tr).find("#codigo").val();
		var cantidadCompra = $(tr).find("#cantidad").val();
		var cosultcom = $(tr).find("#costoJm").val();
		var costojm = $(tr).find("#costoIm").val();
		var precio = $(tr).find("#precio").val();

		if( verificarFormatoCodigo( codidoArt ) )
		{
			var codigoSelec = obtenerNumeroAPartirDeCodigo(codidoArt);
			var articuloAcomprar = comprados[codigoSelec];
			articuloAcomprar.cantdisp = articuloAcomprar.cantdisp == null? 0:articuloAcomprar.cantdisp;
			articuloAcomprar.ultcostpr = articuloAcomprar.costprom;
			articuloAcomprar.ultcosproi = articuloAcomprar.costpromim;
			articuloAcomprar.invimpante = articuloAcomprar.invimppas;
			articuloAcomprar.fecanteimp = articuloAcomprar.fecultimp;
			articuloAcomprar.invimppas = articuloAcomprar.cantdisp + cantidadCompra;
			articuloAcomprar.fecultimp = darFechaActual();
			articuloAcomprar.costprom = ( articuloAcomprar.costprom*articuloAcomprar.cantdisp + cosultcom*cantidadCompra)/( articuloAcomprar.cantdisp + cantidadCompra );
			articuloAcomprar.costpromim = ( ( articuloAcomprar.costpromim*articuloAcomprar.cantdisp ) + ( costojm * cantidadCompra ) )/( articuloAcomprar.cantdisp + cantidadCompra );
			articuloAcomprar.precio = precio;
			articuloAcomprar.costjm = costojm;
			articuloAcomprar.ultcomp = cantidadCompra;
			articuloAcomprar.cantdisp += cantidadCompra;
			articuloAcomprar.cosultcom = cosultcom;
			
			if(articuloAcomprar.costprom == null || articuloAcomprar.costprom == 0 )
			{
				articuloAcomprar.costprom = cosultcom;
			}
			
			if(articuloAcomprar.costpromim == null || articuloAcomprar.costpromim == 0 )
			{
				articuloAcomprar.costpromim = costjm;
			}
			$.ajax
			({
				type : "put",
				url : "/api/articulos/" + codigoSelec,
				data : JSON.stringify(articuloAcomprar),
			    contentType: 'application/json; charset=utf-8',
				success : function(data) 
				{
					crearCardex( data, cantidadCompra, tr );
					actualizarGenero(data, tr);
				},
				error : function(data) 
				{
					alert("El artículo con id "+data.codigo+" no se actualizó!!");
				}
			});
			actualizo = true;
		}
		else
		{
			alert("El código de alguno de los artículos no coincide con el formato: 000-000-0");
			$(tr).find("#codigo").val("000-000-0");
		}
	}
	return actualizo;
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
	
	var doc = $(tr).find("#doc").val().toUpperCase();
	var nDoc = $(tr).find("#nDoc").val();

	nCardex.codigo = articulo.codigo;
	nCardex.fecha = darFechaActual();
	nCardex.tipo = "E";
	nCardex.documento =  doc;
	nCardex.cantidad = nCantidad;
	nCardex.ndoc = nDoc;
	nCardex.saldo = articulo.cantdisp == null? 0:articulo.cantdisp;
	postForObject(nCardex, "/api/cardex", 
			function(data){},function(data){alert("Error al agregar un nuevo registro a la hoja Cardex!!");} );

}


/**
 * Se encarga de obtener el objeto género asocaido al codigo ingresado del artículo 
 * que se esta modificando. Luego autocompleta, en el formulario los demás atributos del artículo.
 * @param articuloSelec: Articulo seleccionado.
 * @param trSelect: Fila HTML donde se encuentra el artículo que se comprará.
 * */
function actualizarGenero(articuloSelec, cantidadCompra, trSelect) 
{
	var idGenero = Math.floor(articuloSelec.codigo/1000);
	$.ajax({
		url : "/api/generos/" + idGenero,
		success : function(data) 
		{
			data.cantdispjm = cantdispjm + cantidadCompra;
			putForObject(data, "/api/cardex", 
					function(data){},function(data){alert("Error al actualizar cantdispjm del género " data.nombre +"!!");} );
		},
		error : function(data) 
		{
			alert("Este artículo no esta relacionado a algún género");
		}
	});	
}