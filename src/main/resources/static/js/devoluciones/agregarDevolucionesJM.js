/**
 * Mapa donde se guardan los artículos que el usuario desea comprar.
 * Llave: Código del artículo.
 * Valor: Objeto artículo.
 * */
var artiEnTabla = new Object();
var articulosDevueltosJM = [];

$(document).ready(
function() 
{ 
	iniciarFormulario();
});

/**
 * Se encarga de inicar lo componentes del formualrio y revisar si llega el código
 * de algún artculo en la URL.
 * */
function iniciarFormulario()
{
	obtenerFilaSelec();
	$("form").submit(agregarDevoluciones);	
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
	 var columnaFactura= $("<td>");
	 var columnaTipo= $("<td>");
	 var columnaFecha= $("<td>");
	 var columnaCliente = $("<td>");
	 var columnaDoc= $("<td>");
	 var columnaNdoc= $("<td>");
	 var columnaCantidad= $("<td>");


	 var valorColumnaCodigo= $("<input>",{id:"codigo", type:"text"});
	 var valorColumnaNombre= $("<input>",{id:"nombre", type:"text", readonly:"readonly"});
	 var valorColumnaReferencia= $("<input>",{id:"referencia", type:"text",readonly:"readonly"});
	 var valorColumnaFactura= $("<input>",{id:"factura", type:"number", required:"required"});
	 var valorColumnaTipo= $("<input>",{id:"tipo", type:"number", required:"required"});
	 var valorColumnaFecha= $("<input>",{id:"fecha", type:"number", required:"required"});
	 var valorColumnaCliente= $("<input>",{id:"cliente", type:"text", required:"required"});
	 var valorColumnaDoc= $("<input>",{id:"doc", type:"text", required:"required"});
	 var valorColumnaNdoc= $("<input>",{id:"nDoc", type:"number", required:"required"});
	 var valorColumnaCantidad= $("<input>",{id:"cantidad", type:"number"});

	 columnaCodigo.append(valorColumnaCodigo);
	 columnaNombre.append(valorColumnaNombre);
	 columnaReferencia.append(valorColumnaReferencia);
	 columnaFactura.append(valorColumnaFactura);
	 columnaTipo.append(valorColumnaTipo);
	 columnaFecha.append(valorColumnaFecha);
	 columnaCliente.append( valorColumnaCliente )
	 columnaDoc.append(valorColumnaDoc);
	 columnaNdoc.append(valorColumnaNdoc);
	 columnaCantidad.append(valorColumnaCantidad);
	 
	 nuevaFila.append(columnaCodigo);
	 nuevaFila.append(columnaNombre);
	 nuevaFila.append(columnaReferencia);
	 nuevaFila.append(columnaFactura);
	 nuevaFila.append(columnaTipo);
	 nuevaFila.append(columnaFecha);
	 nuevaFila.append(columnaCliente );
	 nuevaFila.append(columnaDoc);
	 nuevaFila.append(columnaNdoc);
	 nuevaFila.append(columnaCantidad);
	 
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
	$(trSelec).find("#factura").val("");
	$(trSelec).find("#tipo").val("");
	$(trSelec).find("#doc").val("");
	$(trSelec).find("#nDoc").val("");
	$(trSelec).find("#fecha").val("");
	$(trSelec).find("#cliente").val("");
	
	if( verificarFormatoCodigo( codigoConFormato ) )
	{
		var codigoSelec = obtenerNumeroAPartirDeCodigo(codigoConFormato);
		if( obtenerCheckSum( codigoSelec ) == darCheckSumDeCodigo( codigoConFormato ) )
		{
			$(trSelec).find("#codigo").attr("readonly", "readonly");
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
	
	artiEnTabla[articuloSelec.codigo] = articuloSelec;
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
 * que el usuario ha decidio agregar a devolucion, para luego delegar la función
 * de actualizarlos en la base de datos.
 * @param ev: Evento, asociado al clic del ratón, que se dispara cuando el 
 * 			  usuario decide persistir los cambios hechos.
 * */
function agregarDevoluciones(ev)
{		
	ev.preventDefault();
	var devueltos = 0;
	$("table tr").each(function(i,tr){
		if (actualizarArticulo(i, $(tr)))
		{
			devueltos++;
		}
	});
	console.log(articulosDevueltosJM);
	$.ajax
	({
		type : "put",
		url : "/api/devolucionJM/",
		data : JSON.stringify(articulosDevueltosJM),
	    contentType: 'application/json; charset=utf-8',
		success : function(data) 
		{
			
		},
		error : function(data) 
		{
			alert("Error al agregar las devoluciones!!!!!!");
		}
	});
	
	if ( devueltos > 0 )
	{
		alert("Se han egistrado exitósamente los "+devueltos+" artículos devueltos!");
	}
	else
	{
		alert("No se registró alguna devolución!");
	}
	
	location.reload();
}


/**
 * Función encargada de modificar un artículo en la base de datos.
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
		var cardex;
		var genero;
		var codidoArt = $(tr).find("#codigo").val();
		var cantidadDevolucion = parseFloat($(tr).find("#cantidad").val());

		if( verificarFormatoCodigo( codidoArt ) )
		{
			if( cantidadDevolucion != 0 )
			{
				var codigoSelec = obtenerNumeroAPartirDeCodigo(codidoArt);
				var articuloAdevolver = artiEnTabla[codigoSelec];
				
				articuloAdevolver.cantdisp += cantidadDevolucion;
				cardex = crearCardex( articuloAdevolver, cantidadDevolucion, tr );	
				devolucion = { articulo:articuloAdevolver, cardex:cardex};
				
				articulosDevueltosJM.push(devolucion);
				
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

/**
 * Función encargada de crear un nuevo objeto Cardex.
 * @param articulo: Articulo asociado al nuevo objeto Cardex.
 * @param tr: Fila HTML donde se encuentra el artículo al que se le actualizará, 
 * 			  en la base de datos, la cantidad.
 * */
function crearCardex( articulo, cantidadDevolucion, tr )
{
	var nCardex = new Object();
	
	var doc = $(tr).find("#doc").val().toUpperCase();
	var nDoc = $(tr).find("#nDoc").val();

	nCardex.codigo = articulo.codigo;
	nCardex.fecha = darFechaActual();
	nCardex.tipo = "E";
	nCardex.documento =  doc;
	nCardex.cantidad = cantidadDevolucion;
	nCardex.ndoc = nDoc;
	nCardex.saldo = articulo.cantdisp;
		
	return nCardex;
}

/**
 * Función encargada de crear un nuevo objeto Importacion.
 * @param codigo: Código del articulo asociado a la Importacion.
 * @param tr: Fila HTML donde se encuentra el artículo que se comprará.
 * */
function crearImportacion( articulo, tr )
{
	var nImport = new Object();

	var cosultcom = $(tr).find("#costoJm").val();
	var costojm = $(tr).find("#costoIm").val();
	var precio = $(tr).find("#precio").val();
	var doc = $(tr).find("#doc").val().toUpperCase();
	var nDoc = $(tr).find("#nDoc").val();
	
	nImport.fecha = darFechaActual();
	nImport.codigo = articulo.codigo;
	nImport.cantidad = articulo.ultcomp;
	nImport.costojm = cosultcom;
	nImport.costoim = costojm;
	nImport.documento =  doc;
	nImport.ndoc = nDoc;
	nImport.precio = precio;
		
	return nImport;
}