/**
 * Mapa donde se guardan los artículos que el usuario desea comprar.
 * Llave: Código del artículo.
 * Valor: Objeto artículo.
 * */
var artiEnTabla = new Object( );
var articulo = new Object ();
var WcamRef = "N";
var NFact = new Object( );
var cliente = null;
var minimo;
/*El anterior desarrollador los nombro asi y no se para que p*#! sirve*/
var porXX = 1;
var porYY = 1;
var porZZ = 1;

$(document).ready(function(){
	iniciarFormulario();
})


/**
 * Se encarga de inicar lo componentes del formualrio y revisar si llega el código
 * de algún artculo en la URL.
 * */
function iniciarFormulario()
{
	obtenerFilaSelec();
	caprurarTab();
	cargarFormasPago();
	cargarNotas();
	cargarNFact();
	llenarFecha();
	cargarCiudad();
	cargarCorrerias( );
	cargarVendedores( );
	cargarLineas( );
	cargarCliente();
	verificarTipoPrecio( );
	verificarTipoCambiaPrecio( );
}

/**
 * Función encargada de crear abrir una ventana 
 * adicional e imprimir el contenido de la página actual.
 * */
function comprar()
{
	//window.open( "mostrarAdicionales/"); //EN UNA PESTAÑA NUEVA.
	window.open( "mostrarAdicionales?especial="+$( "#cambia-precios").val( ), "", 'width=1000' );
	//window.print();
}

/**
 * Función encargada de crear una nueva fila con campos vacios.
 * */
function agregarFila()
 {
	 var nuevaFila= $( "<tr>" );
	 
	 var columnaCodigo= $( "<td>" );
	 var columnaNombre= $( "<td>" );
	 var columnaReferencia= $( "<td>" );
	 var columnaCantidad= $( "<td>" );
	 var columnaPrecio= $( "<td>" );


	 var valorColumnaCodigo= $( "<input>",{ id:"codigo", type:"text" } );
	 var valorColumnaNombre= $( "<input>",{ id:"nombre", type:"text", readonly:"readonly" } );
	 var valorColumnaReferencia= $( "<input>",{ id:"referencia", type:"text",readonly:"readonly" } );
	 var valorColumnaCantidad= $( "<input>",{ id:"cantidad", type:"number", required:"required" } );
	 var valorColumnaPrecio= $( "<input>",{ id:"precio", type:"number",readonly:"readonly" } );

	 columnaCodigo.append( valorColumnaCodigo );
	 columnaNombre.append( valorColumnaNombre );
	 columnaReferencia.append( valorColumnaReferencia );
	 columnaCantidad.append( valorColumnaCantidad );
	 columnaPrecio.append( valorColumnaPrecio );
	 
	 nuevaFila.append(columnaCodigo);
	 nuevaFila.append(columnaNombre);
	 nuevaFila.append(columnaReferencia);
	 nuevaFila.append(columnaCantidad);
	 nuevaFila.append(columnaPrecio);
	 
	 $("table").append(nuevaFila);
 }

/**
 * Se encarga de verificar que el tipo 
 * de precio sea M, V, M+, ó ++.
 * */
function verificarTipoPrecio()
{

	$("#precioM").on( "change",
	function(ev) 
	{
		var regex = new RegExp("M|V|M\+|\\+\\+");
		var precio = $(this).val( ).toUpperCase();
		$(this).val( precio );
		if( !regex.test( precio ) )
		{
			$(this).val( "" );
			alert( "El precio debe ser M, V, M+, ó ++")
		}
	});
}

/**
 * Se encarga de verificar que el tipo 
 * de cambia-precio sea S ó N
 * */
function verificarTipoCambiaPrecio(){
	$("#cambia-precios").on( "change",
	function(ev) 
	{
		var regex = new RegExp("S|N");
		var precio = $(this).val( ).toUpperCase();
		$(this).val( precio );
		if( !regex.test( precio ) )
		{
			$(this).val( "" );
			alert( "El precio debe ser S ó N" );
		}
	});
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
		obtenerAtributosArticulo( trSelec );
	});
	
	$("table").on("change", "input[id=cantidad]", 
			function(ev) 
			{
				var trSelec = $(this).parent().parent();
				var codigo = obtenerNumeroAPartirDeCodigo( $( trSelec ).find( "#codigo" ).val( ) );
				if( artiEnTabla[codigo] != null )
					articulo = artiEnTabla[codigo];
				
				if( validarCantidad( trSelec ) )
				 {
					artiEnTabla[articulo.codigo] = articulo;
				 }
			});
}

/**
 * Se encarga de capturar la fila cuya columna "Precio" se esta modificando.
 * Para así agregar una nueva fila al final.
 * */
function caprurarTab()
{
	$("table").on("keydown", "#precio", 
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
 * Se encarga de obtener el objeto articulo asocaido al codigo ingresado.
 * teniendo en cuenta que fila se esta modificando.
 * @param trSelec: Fila HTML donde se encuentra el artículo que se comprará.
 * */
function obtenerAtributosArticulo( trSelec)
{
	var codigoConFormato = $(trSelec).find("#codigo").val();
	$(trSelec).find("#nombre").val( "" );
	$(trSelec).find("#referencia").val( "" );
//	$(trSelec).find("#cantidad").val( "" );
	$(trSelec).find("#precio").val( "" );
	if( verificarFormatoCodigo( codigoConFormato ) )
	{
		var codigoSelec = obtenerNumeroAPartirDeCodigo( codigoConFormato );
		
		if( artiEnTabla[codigoSelec] != null )
			alert( "Este artículo ya se encuentra registrado en la tabla de pedidos a facturar!!!! Si queires más unidades aumenta el pedido en la columna cantidad de este producto. ");
		
		else
		{	
			if( obtenerCheckSum( codigoSelec ) == darCheckSumDeCodigo( codigoConFormato ) )
			{
				$("#codigo-1").attr("readonly", "readonly");
				$("#cambia-precios").attr("readonly", "readonly");
				$("#precioM").attr("readonly", "readonly");
				$.ajax
				({	
					url : "/api/articulos/" + codigoSelec + "/especial?idCliente=" + $("#codigo-1").val(),
					success : function( data ) 
					{
						obtenerGenero( data, trSelec );
					},
					error : function( data ) 
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
	}
	else
	{
		alert("Este código no coincide con el formato: 000-000-0");
		$(trSelec).find("#codigo").val("000-000-0");
	}
}

/**
 * Se encarga de validar que el código del artículo que se facturará se 
 * encuentre entre los códigos límites permitidos dependiendo de la línea 
 * a la que pertenece el cliente. De noser así informa al usuario y no 
 * permite facturar dicho artículo.
 * @param idGenero: Id del artículo seleccionado.
 * @param trSelect: Fila HTML donde se encuentra el artículo que se comprará.
 * */
function verificarIntervaloCodigo( idGenero, trSelect ) 
{
	var minCode, maxCode;
	
	minCode = parseInt( $("#linea option:selected" ).text().substring( 3, 6 ) );
	maxCode = parseInt( $("#linea option:selected" ).text().substring( 7 ) );
	if( idGenero < minCode || idGenero > maxCode )
	{
		alert( "Los articulos a facturar deben estar entre los códigos: " + minCode + " y " + maxCode );
		$(trSelect).find("#codigo").val("000-000-0");
		return false;
	}
	
	return true;
}

/**
 * Se encarga de obtener el objeto género asocaido al codigo 
 * ingresado del artículo que se esta modificando. 
 * Luego autocompleta, en el formulario los demás atributos del artículo.
 * @param precioArticuloSelec: precio del artículo seleccionado.
 * @param trSelect: Fila HTML donde se encuentra el artículo que se comprará.
 * */
function adecuarPrecioaCliente( precioArticuloSelec, trSelect ) 
{
	var precioM = $("#precioM").val();
	var precio = precioArticuloSelec;
	if ( precioM === "V" )
    {
		precio = precioArticuloSelec + ( precioArticuloSelec * NFact.porcfactur / 100 );
    }
	else
    {
		if ( precioM === "M+" )
		{
			precio = precioArticuloSelec + ( precioArticuloSelec * NFact.porcfacmas / 100 ); 
		}
		else
		{	
			if ( precioM === "++" )
			{
				precio = precioArticuloSelec + ( precioArticuloSelec * NFact.porcplus / 100 ); 
			}
		}
    }

	if( $( "#cambia-precio").val( ) !== "S" || WcamRef === "S" )
		$(trSelect).find("#precio").attr( "readOnly", "readOnly" );
	else
		$(trSelect).find("#precio").removeAttr( "readOnly" );
	
	return precio;
}

/**
 * Se encarga de obtener el objeto género asocaido al codigo 
 * ingresado del artículo que se esta modificando. 
 * Luego autocompleta, en el formulario los demás atributos del artículo.
 * @param articuloSelec: Artículo seleccionado.
 * @param trSelect: Fila HTML donde se encuentra el artículo que se comprará.
 * */
function obtenerGenero( articuloSelec, trSelect ) 
{
	var idGenero = Math.floor( articuloSelec.codigo/1000 );	
	var genero;
	var cantidadDisponible = 0;
	
	if( verificarIntervaloCodigo( idGenero, trSelect ) )
	{
		$.ajax({
			url : "/api/generos/" + idGenero,
			success : function(data) 
			{
				genero = data;
				genero.cantdispf = articuloSelec.cantdisp;
				
				if ( articuloSelec.cantdisp != null )
					cantidadDisponible = articuloSelec.cantdisp;
				
				if( genero.cantdispf < cantidadDisponible )
					minimo = genero.cantdispf;
				else
					minimo = cantidadDisponible;
				$(trSelect).find("#nombre").val( genero.nombre );
			},
			error : function(data) 
			{
				alert("Este artículo no esta relacionado a algún género");
			}
		});
		
		articuloSelec.precio = adecuarPrecioaCliente( articuloSelec.precio, trSelect ) ;
		
		if( articuloSelec.referencia != null )
		{
			$(trSelect).find("#referencia").val( articuloSelec.referencia );
		}
		else
		{
			$(trSelect).find("#referencia").val( 0 );
		}
		
		if( articuloSelec.precio != null )
		{	
			$(trSelect).find("#precio").val( articuloSelec.precio );
		}
		else
		{
			$(trSelect).find("#precio").val(0);
		}
		articulo = articuloSelec;
	}
}

/**
 * Se encarga de validar que la cantidad a pedir de un artículo 
 * sea igual o menor a la cantidad disponible. De no ser así 
 * informa al usuario la cantidad máxima disponible de dicho artículo
 * y pide un confirmación en caso de quiera esa cantidad máxima.
 * @param trSelect: Fila HTML donde se encuentra el artículo que se comprará.
 * @param minimo: Cantidad maxima del ariculo.
 * */
function validarCantidad( trSelect )
{
	var respuesta = false;
	var cantidadPedida = parseInt( $(trSelect).find("#cantidad").val( ) );
	
	if( cantidadPedida > 0 )
	{
		if( cantidadPedida > minimo )
		{
			if( minimo > 0 )
			{ 
				respuesta = confirm(" Solo existen: " + minimo + " unidad(es) disponibles de este artículo. Desea Facturarlas (S/N)? ");
				cantidadPedida = minimo;
			}
			else
			{
				alert( "No Hay existencias para ese artículo" );
			}
		}
		else
		{	
			respuesta = true;
		}
	}
	else
	{	
		alert( "La cantidad solicitada de: " + $(trSelect).find("#nombre").val() + " debe ser mayor a 0 (cero)." );
		$(trSelect).find("#cantidad").val( 0 );
		return respuesta;
	}
	
	if( respuesta )
	{
		$(trSelect).find("#cantidad").val( cantidadPedida );
		var totalCantidad = parseInt( $("#totalCantidad").val( ) );
		var totalPrecio = parseFloat( $("#totalPrecio").val( ).substring( 2 ) );
		
		totalCantidad += cantidadPedida;
		totalPrecio += ( cantidadPedida * articulo.precio );
		articulo.ultcomp = cantidadPedida;
		
		$("#totalCantidad").val( totalCantidad );
		$("#totalPrecio").val( "$ " + totalPrecio );
		return respuesta;
	}
	else
	{
		$(trSelect).find("#codigo").val("000-000-0");
		$(trSelect).find("#nombre").val( "" );
		$(trSelect).find("#referencia").val( "" );
		$(trSelect).find("#cantidad").val( "" );
		$(trSelect).find("#precio").val( "" );
		return respuesta
	}
}

/**
 * Se encarga de capturar el evento asociado 
 * a cuando el codigo del cliente cambia.
 * Para luego obtener el objet Cliente por 
 * consumiendo el api.
 * */
function cargarCliente()
{
	$('#codigo-1').change(function(event)
	{
		var codigo = $(this).val();
		$.ajax({
			url: '/api/clientes/'+codigo+"?projection=factura",
			success: function( data )
			{
				cliente = data;
				completarCliente( data );
			},
			error: function( data )
			{
				completarCliente( null );
			}
		})
	})
}

/**
* Se encarga de completar la información del cliente
* con la información encapsulada en @cliente.
* @parama cliente: Información del cliente que se mostrará.
* */
function completarCliente( cliente )
{
	var nit = 0;
	var razonSocial = "No cliente";
	var direccion = "N/A";
	var ciudad = new Object();
	var mensaje = "Este código no esta asociado a alguna ciudad!";
	var linea = 0;
	var correria = 0;
	var vendedor = "A";

	if( cliente != null )
	{
		if( cliente.camref != null )
		{
			WcamRef = cliente.camref;
		}
		
		if( cliente.nit == null )
		{
			if( cliente.cc != null )
				nit = cliente.cc;
		}
		else
			nit = cliente.nit;
		
		razonSocial = cliente.razsoc;
		direccion = cliente.direccion;
		
		if( cliente.ciudad != null )
		{
			ciudad = cliente.ciudad;
			mensaje = " ";
		}
		
		if( cliente.linea.linea != null )
			linea = cliente.linea.linea;
		
		if( cliente.codcorr.codigo != null )
			correria = cliente.codcorr.codigo;
		
		if( cliente.vendedor.codigo != null )
			vendedor = cliente.vendedor.codigo;	
		
		completarEsEspecial( cliente.codigo );
	}
	else
	{
		ciudad.codigo = 10;
		ciudad.ciudad = "Bogotá D.C.";
		mensaje = " ";

		alert("Error, cliente NO existe en la base de datos!")
	}
	
	$('#precioM').val( "M" );
	$('#cambia-precios').val( "N" );
	$('#nit').val( nit );
	$('#codigo-2').val( razonSocial );
	$('#direccion').val( direccion );
	$("#linea").val( linea );
	$("#correria").val( correria );
	$("#vendedor").val(  vendedor );
	completarCiudad( ciudad, mensaje );
}

/**
 * Verifica si el cliente tiene articulos con referencia
 * especial para procesarlo de manera distinta.
 * @param codigo: Codigo del cliente que se verificará.
 */
function completarEsEspecial( codigo )
{
	getForObject( { codigo: codigo }, "/api/especia/search/findByCodigo", 
				function sucess( data )
				{
					if( data._embedded.especias.length != 0 )
					{
						$("#cambia-precios").val("S");
					}
					else
					{
						$("#cambia-precios").val("N");
					}
				},
				function error( data )
				{
					
				} );
}

/**
 * Obtiene la ciudad asociada a el código que digita el usuario.
 */
function cargarCiudad( ){
	$("#ciudad-1").keyup(function(event) {
		var codigo = $(this).val();
		$.ajax({
			url: "/api/ciudades/"+codigo,
			success:function(data){
				ciudad = data;
				completarCiudad(ciudad, " ");
			},
			error: function(data){
				completarCiudad(null, "Este código no esta asociado a alguna ciudad!" );
			}
		})
	})
}

/**
 * Completa la información del cliente con la ciudad a la que pertenece.
 * @param ciudad: Ciudad a la que pertenece el cliente.
 * @param mensaje: Mensaje de información para el cliente, por si la ciudad no existe. 
 */
function completarCiudad( ciudad, mensaje )
{
	if( ciudad != null )
	{
		$( "#ciudad-1" ).attr( "readonly", "readonly" );	
		$( "#ciudad-2" ).attr( "readonly", "readonly" );	
		$( "#ciudad-2" ).val( ciudad.ciudad );
		$( "#ciudad-1" ).val( ciudad.codigo );
	}
	else
	{
		$("#ciudad-1").val( 0 );
		$("#ciudad-1").removeAttr( "readonly" );	
		$("#ciudad-2").removeAttr( "readonly" );	
		alert( mensaje );		
	}
}

function cargarNFact(){
	$.ajax({
		url: '/api/nfact/1',
		success: function(data){
			NFact = data;
			llenarFactIva(NFact.factiva);
		},
		error: function(data){
			console.log('Error al obtener los datos');
		}
	})
}

function llenarFactIva(data)
{
	$('#factura').val(data+1);
}

/**
 * Obtiene las notas registradas en el sistema por medio del API.
 */
function cargarNotas ()
{
	$.ajax({
		url: '/api/textosFactura',
		success: function( data )
		{
			llenarNotas( data );
		},
		error: function( data )
		{
			console.log('error al obtener los datos');
		}
	})
}

function llenarNotas( data )
{
	var textosFactura = data._embedded.textosFactura;
	var notas = $( '#notas' );
	for( var i = 0; i < textosFactura.length; i++ )
	{
		var codigo = textosFactura[i].codigo;
		var txt1 = textosFactura[i].texto1!=null?textosFactura[i].texto1:'';
		txt1 = txt1.replace("&DIAS", textosFactura[i].dias+"");

		var txt2 = textosFactura[i].texto2!=null?textosFactura[i].texto2:'';
		txt2 = txt2.replace("&PORCENTAJE", textosFactura[i].porcentaje+"");
		
		var txt3 = textosFactura[i].texto3!=null?textosFactura[i].texto3:'';
		
		var texto = zeroPad(codigo+'',3) + ' '  + txt1 + txt2 + txt3;
		notas.append($('<option>', 
		  {
			text: texto,
			value: codigo,
			title: codigo
		  }));
	}
}

function cargarFormasPago(){
	$.ajax({
		url: '/api/plazos',
		success: function(data){
			llenarFormasPago(data);
		},
		error: function(data){
			alert('Error al obtener las formas de pago!');
		}
	});
}

function llenarFormasPago( formasPago )
{
	var plazos = formasPago._embedded.plazos;
	var formaPago = $('#forma-pago');
	for( var i=0; i< plazos.length; i++ ){
		var tipo = plazos[i].tipo;
		var descripcion = plazos[i].forma + ' ' + plazos[i].descripcion;
		formaPago.append($('<option>', {
			text: descripcion,
			value: tipo,
			title: plazos[i].forma
		}));
	}
}

function llenarFecha(){
	var fechaActual = darFechaActual( );
	$( '#fecha' ).val( formatearFecha( fechaActual ) );
}


/**
 * Obtiene las correrías registradas en el sistema 
 * a través del api por medio de AJAX.
 */
function cargarCorrerias( )
{
	$.ajax({
		url: '/api/corrers',
		success: function(data){
			llenarCorrerias( data );
		},
		error: function(data){
			alert('Error al obtener las correrías!');
		}
	})
}

/**
 * Llena un combobox de correrias con las 
 * correrías en @correrias.
 * @param correrias: Correrías en el sistema obtenidas por medio del api.
 */
function llenarCorrerias( correrias )
{
	correrias = correrias._embedded.corrers;
	var comboCorreria = $("#correria");
	var option;
	
	for( var i = 0; i < correrias.length; i++ )
	{ 
		option = $("<option>", 
		{ 
			value: correrias[i].codigo, 
			text: zeroPad( correrias[i].codigo, 3) +" " + correrias[i].nombre 
		} );
		comboCorreria.append( option );
	}
}

/**
 * Obtiene las líneas registradas en el sistema 
 * a través del api por medio de AJAX.
 */
function cargarLineas( )
{
	$.ajax({
		url: '/api/lineas',
		success: function(data){
			llenarLineas( data );
		},
		error: function(data){
			alert('Error al obtener las lineas!');
		}
	})
}

/**
 * Llena un combobox de líneas con las 
 * líneas en @lineas.
 * @param lineas: Lineas en el sistemas obtenidad por medio del api.
 */
function llenarLineas( lineas )
{
	lineas = lineas._embedded.lineas;
	var comboLinea = $("#linea");
	var option;
	
	for( var i = 0; i < lineas.length; i++ )
	{ 
		option = $("<option>", 
		  {
			value: lineas[i].linea, 
			text: zeroPad( lineas[i].linea, 2 ) + " " 
			+ zeroPad( lineas[i].rango1, 3 ) +"-" + zeroPad( lineas[i].rango2, 3 ) 
		  } );
		
		comboLinea.append(option);
	}
}

/**
 * Obtiene los vendedores registradas en el sistema 
 * a través del api por medio de AJAX.
 */
function cargarVendedores( )
{
	$.ajax({
		url: '/api/vendedores',
		success: function(data){
			llenarVendedores( data );
		},
		error: function(data){
			alert('Error al obtener los vendedores!');
		}
	})
}

/**
 * Llena un combobox de vendedores con los 
 * vendedores en @vendedores.
 * @param vendedores: Vendedores en el sistemas obtenidad por medio del api.
 */
function llenarVendedores( vendedores )
{
	vendedores = vendedores._embedded.vendedores;
	var comboVendedores= $("#vendedor");
	var option;
	
	for( var i = 0; i < vendedores.length; i++ )
	{ 
		option = $("<option>", { value: vendedores[i].codigo, text: vendedores[i].codigo + " " + vendedores[i].nombre } );
		comboVendedores.append( option );
	}
}

/**
 * Completa los campos "dias" y "porcentaje" 
 * dependiendo de la nota seleccionada.
 */
function cambioDeNotas( )
{
	var codigo = $("#notas").val( );
	getForObject( null, "/api/textosFactura/"+codigo, 
			function sucess( data )
			{
				$( "#dias" ).val( data.dias );
				$( "#porcentaje" ).val( data.porcentaje );
			},
			function error( data )
			{
				alert( "Selecciona una nota!!")
			} );
}

/**
 * Completa los campos "dias" y "porcentaje" 
 * dependiendo de la nota seleccionada.
 */
function cambioDeFormaPago( )
{
	var tipo = $("#forma-pago").val( );
	if ( tipo === "C" )
	{
		$( "#diasPago").attr( "readOnly", "readOnly" );
		$( "#diasPago").removeAttr( "required" );
		$( "#diasPago").css( "display", "none" );
		$( "#labelDiasPago").css( "display", "none" );
	}
	else
	{
		$( "#diasPago").removeAttr( "readOnly" );
		$( "#diasPago").attr( "required", "required" );
		$( "#diasPago").css( "display", "" );
		$( "#labelDiasPago").css( "display", "" );
	}	
}