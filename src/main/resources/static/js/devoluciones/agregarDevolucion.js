/**
 * Mapa donde se guardan los artículos que el usuario desea agregar a devolucion.
 * Llave: Código del artículo.
 * Valor: Objeto artículo.
 * */
var articulosEntabla = new Object();
var articulosDevueltos = [];

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
	capturarTab();
	$("form").submit(agregarDevoluciones);	
}

/**
 * Se encarga de capturar la fila cuya columna "nDoc" se esta modificando.
 * Para así agregar una nueva fila al final.
 * */
function capturarTab()
{
	$("table").on("keydown", "#nDoc", 
	function(ev) 
	{
		var code = ev.keyCode || ev.which;
		if (code == '9') 
		{
			agregarFila();
		}
		var trSelec = $(this).parent().parent();
	});
}

/**
 * Función encargada de crear una nueva fila con campos vacios.
 * */
function agregarFila()
 {
	 var nuevaFila= $("<tr>");
	 
	 var columnaCodigo= $("<td>");
	 var columnaNombre= $("<td>");
	 var columnaCantidad= $("<td>");
	 var columnaDoc= $("<td>");
	 var columnaNdoc= $("<td>");


	 var valorColumnaCodigo= $("<input>",{id:"codigo", type:"number"});
	 var valorColumnaNombre= $("<input>",{id:"nombre", type:"text", readonly:"readonly"});
	 var valorColumnaCantidad= $("<input>",{id:"cantidad", type:"number", required:"required"});
	 var valorColumnaDoc= $("<input>",{id:"doc", type:"text", required:"required"});
	 var valorColumnaNdoc= $("<input>",{id:"nDoc", type:"number", required:"required"});

	 columnaCodigo.append(valorColumnaCodigo);
	 columnaNombre.append(valorColumnaNombre);
	 columnaCantidad.append(valorColumnaCantidad);
	 columnaDoc.append(valorColumnaDoc);
	 columnaNdoc.append(valorColumnaNdoc);
	 
	 nuevaFila.append(columnaCodigo);
	 nuevaFila.append(columnaNombre);
	 nuevaFila.append(columnaCantidad);
	 nuevaFila.append(columnaDoc);
	 nuevaFila.append(columnaNdoc);
	 
	 $("table").append(nuevaFila);
 }

/**
 * Se encarga de capturar la fila cuya columna "Código" se esta modificando.
 * Para así obtener el artículo que se devolverá.
 * */
function obtenerFilaSelec()
{
	$("table").on("change", "input[id=codigo]", 
	function(ev) 
	{
		var trSelec = $(this).parent().parent();
		
		$(trSelec).find("#nombre").val("");
		$(trSelec).find("#cantidad").val("");
		$(trSelec).find("#doc").val("");
		$(trSelec).find("#nDoc").val("");
		
		obtenerAtributosArticulo(trSelec);
	});
}

/**
 * Se encarga de obtener el objeto genero asocaido al codigo ingresado.
 * teniendo en cuenta que fila se esta modificando.
 * @param trSelec: Fila HTML donde se encuentra el artículo que se agregará a devoluciones.
 * */
function obtenerAtributosArticulo( trSelec )
{
	var idGenero = $(trSelec).find("#codigo").val();
	
	$.ajax(
	{
		url : "/api/generos/" + idGenero,
		success : function(data) 
		{
			$(trSelec).find("#codigo").attr("readonly", "readonly");
			$(trSelec).find("#nombre").val( data.nombre );
			$(trSelec).find("#cantidad").val( 0 );
			articulosEntabla[data.codigo] = data;
		},
		error : function(data) 
		{
			articulosEntabla[idGenero] = null;
			alert("Este artículo no existe!!");
		}
	});
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
	//console.log(articulosDevueltos);
	$.ajax
	({
		type : "put",
		url : "/api/devolucion/",
		data : JSON.stringify(articulosDevueltos),
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
 * Función encargada de agregar a devolucion los articulos editados.
 * @param i: Índice de la fila donde se encuentra el artículo a modificiar. Sirve para controlar 
 * 			 que la fila en @tr que se recibe no sea el encabezado de la tabla.
 * @param tr: Fila HTML donde se encuentra el artículo al que se le actualizará, 
 * 			  en la base de datos, el precio.
 * */
function actualizarArticulo( i, tr )
{
	var actualizo = false;
	var devolucion;

	if ( i > 0 )
	{
		var codigoArt = $(tr).find("#codigo").val();
		var cantidadDevolucion = parseFloat($(tr).find("#cantidad").val());
		
		if( articulosEntabla[codigoArt] != null && cantidadDevolucion != 0 )
		{
			articulosEntabla[codigoArt].cantdisp += cantidadDevolucion;
			cardex = crearCardex( articulosEntabla[codigoArt], tr, cantidadDevolucion );	
			devolucion = { genero:articulosEntabla[codigoArt], cardexi:cardex };
			articulosDevueltos.push(devolucion);
			actualizo = true;
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
function crearCardex( articulo, tr, cantidadDevolucion )
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