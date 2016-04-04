/**
 * Mapa donde se guardan los artículos que el usuario desea actualizar.
 * Llave: Código del artículo.
 * Valor: Objeto artículo
 * */
var cambiados = new Object();

$(document).ready(
function() 
{ 
	iniciarFormulario();
});

/**
 * Se encarga de capturar la fila cuya columna "nPrecio" se esta modificando.
 * Para así agregar una nueva fila al final.
 * */
function capturarTab()
{
	$("table").on("keydown", "#nPrecio", 
	function(ev) 
	{
		var code = ev.keyCode || ev.which;
		if (code == '9') 
			agregarFila();
		var trSelec = $(this).parent().parent();
	});
}

/**
 * Se encarga de inicar lo compnentes del formualrio y revisar si llega el código
 * de algún artculo en la URL.
 * */
function iniciarFormulario()
{
	obtenerFilaSelec();
	capturarTab();
	var getCodigo = get("codigo");
	if( getCodigo != null && getCodigo != "")
	{
		var celda = $("#codigo");
		celda.val(getCodigo);
		var trSelec = $(celda).parent().parent();
		celda.attr("readonly","readonly");
		$("#botAgregaFila").attr("style","display:none");	
		obtenerAtributosArticulo(trSelec);
	}
	$("form").submit(guardarCambios);	
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
	 var columnaPrecio= $("<td>");
	 var columnaNprecio= $("<td>");
	 
	 var valorColumnaCodigo= $("<input>",{id:"codigo", type:"text"});
	 var valorColumnaNombre= $("<input>",{id:"nombre", type:"text", readonly:"readonly"});
	 var valorColumnaReferencia= $("<input>",{id:"referencia", type:"text",readonly:"readonly"});
	 var valorColumnaPrecio= $("<input>",{id:"precio", type:"number",readonly:"readonly"});
	 var valorColumnaNprecio= $("<input>",{id:"nPrecio", type:"number", required:"required"});
	 
	 columnaCodigo.append(valorColumnaCodigo);
	 columnaNombre.append(valorColumnaNombre);
	 columnaReferencia.append(valorColumnaReferencia);
	 columnaPrecio.append(valorColumnaPrecio);
	 columnaNprecio.append(valorColumnaNprecio);
	 
	 nuevaFila.append(columnaCodigo);
	 nuevaFila.append(columnaNombre);
	 nuevaFila.append(columnaReferencia);
	 nuevaFila.append(columnaPrecio);
	 nuevaFila.append(columnaNprecio);
	 
	 $("table").append(nuevaFila);
 }

/**
 * Se encarga de capturar la fila cuya columna "Código" se esta modificando.
 * Para así obtener el artículo que se modificará.
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
 * @param trSelec: Fila HTML donde se encuentra el artículo que se modificará.
 * */
function obtenerAtributosArticulo( trSelec)
{
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
			$(trSelec).find("#codigo").val( darCodigoFormateado( codigoSelec ) );
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
 * Se encarga de obtener el objeto género asociado al codigo ingresado del artículo 
 * que se esta modificando. Luego autocompleta, en el formulario los demás atributos del artículo.
 * @param articuloSelec: Articulo seleccionado.
 * @param trSelect: Fila HTML donde se encuentra el artículo que se modificará.
 * */
function obtenerGenero(articuloSelec, trSelect) 
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
 * Función encargada de recorrer la tabla que contiene los artículos a los
 * que el usuario ha decidio cambiarles el precio, para luego delegar la función
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
			actualizados++;
	});
	if ( actualizados > 0 )
		alert("Se han actualizado exitósamente los "+actualizados+" artículos!");
	else
		alert("No se registró algún cambio!");
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