/**
 * Mapa donde se guardan los artículos que el usuario desea comprar.
 * Llave: Código del artículo.
 * Valor: Objeto artículo.
 * */
var artiEnTabla = new Object();
var especiasEnTabla = new Object();
var NFact = null;
var ciudad = null;
var cliente = null;
/*El anterior desarrollador los nombro asi y no se para que putas sirve*/
var porXX = 1;
var porYY = 1;
var porZZ = 1;

$(document).ready(function()
{
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

	//$("form").submit(comprar);	
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
	 var columnaPrecio= $("<td>");


	 var valorColumnaCodigo= $("<input>",{id:"codigo", type:"text"});
	 var valorColumnaNombre= $("<input>",{id:"nombre", type:"text", readonly:"readonly"});
	 var valorColumnaReferencia= $("<input>",{id:"referencia", type:"text",readonly:"readonly"});
	 var valorColumnaCantidad= $("<input>",{id:"cantidad", type:"number", required:"required"});
	 var valorColumnaPrecio= $("<input>",{id:"precio", type:"number"});

	 columnaCodigo.append(valorColumnaCodigo);
	 columnaNombre.append(valorColumnaNombre);
	 columnaReferencia.append(valorColumnaReferencia);
	 columnaCantidad.append(valorColumnaCantidad);
	 columnaPrecio.append(valorColumnaPrecio);
	 
	 nuevaFila.append(columnaCodigo);
	 nuevaFila.append(columnaNombre);
	 nuevaFila.append(columnaReferencia);
	 nuevaFila.append(columnaCantidad);
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
	$(trSelec).find("#nombre").val("");
	$(trSelec).find("#referencia").val("");
	$(trSelec).find("#cantidad").val("");
	$(trSelec).find("#precio").val("");
	if( verificarFormatoCodigo( codigoConFormato ) )
	{
		var codigoSelec = obtenerNumeroAPartirDeCodigo(codigoConFormato);
		if( obtenerCheckSum( codigoSelec ) == darCheckSumDeCodigo( codigoConFormato ) )
		{
			//$(trSelec).find("#codigo").attr("readonly", "readonly");
			$.ajax
			({	
				url : "/api/articulos/" + codigoSelec + "/especial?idCliente=" + $("#codigo-1").val(),
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

	var precio = $("#precio").val();
	
	if ( precio == "V" )
    {
		articuloSelec.precio = articuloSelec.precio + ( articuloSelec.precio * NFact.porcfactur / 100 );
    }
	else
    {
		if ( precio == "M+" )
		{
			articuloSelec.precio = articuloSelec.precio + ( articuloSelec.precio * NFact.porcfacmas / 100 ); 
		}
		else
		{	
			if ( articuloSelec = "++" )
			{
				articuloSelec.precio = articuloSelec.precio + ( articuloSelec.precio * NFact.porcplus / 100 ); 
			}
		}
    }
	
	if( articuloSelec.referencia != null )
	{
		$(trSelect).find("#referencia").val(articuloSelec.referencia);
		
	}
	else
	{
		$(trSelect).find("#referencia").val( 0 );
	}
	
	if(articuloSelec.precio != null )
	{	
		$(trSelect).find("#precio").val(articuloSelec.precio);
	}
	else
	{
		$(trSelect).find("#precio").val(0);
	}	
}

function cargarCliente()
{
	$('#codigo-1').change(function(event){
		var codigo = $(this).val();
		$.ajax({
			url: '/api/clientes/'+codigo+"?projection=factura",
			success: function(data){
				cliente = data;
				completarCliente(data);
			},
			error: function(data){
				completarCliente(null);
			}
		})
	})
}

function completarCliente(cliente)
{
	if( cliente != null )
	{
		if( cliente.camref != null )
		{
			camRef = cliente.camref;
		}
		
		$('#codigo-2').val(cliente.proptario);
		$('#direccion').val(cliente.direccion);
		$('#almacen').val(cliente.razsoc);
		$('#nit').val(cliente.nit)
		$("#linea").val( cliente.linea.linea );
		$("#vendedor").val( cliente.vendedor.codigo );
		$("#correria").val( cliente.codcorr.codigo );
		completarCiudad(cliente.ciudad, "El cliente no tiene una ciudad asociada!");
		completarEsEspecial( cliente.codigo );
	}
	else
	{
		$('#cliente-2').val('Cliente no encontrado');
		completarCiudad(null);
		alert("Este código no esta asociado a algún cliente!")
	}
}

/**
 * Verifica si el cliente tiene articulos con referencia
 * especial para procesarlo de manera distinta.
 * @param codigo: Codigo del cliente del que se verificará.
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
				completarCiudad(ciudad);
			},
			error: function(data){
				completarCiudad(null, "Este código no esta asociado a alguna ciudad!");
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
	if( ciudad!=null)
	{
		$("#ciudad-1").attr("readonly", "readonly" );	
		$("#ciudad-2").val(ciudad.ciudad);
		$("#ciudad-1").val(ciudad.codigo);
	}
	else
	{
		$("#ciudad-1").removeAttr("readonly");	
		alert( mensaje );		
		$("#ciudad-1").val(0);
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
			console.log('error al obtener los datos');
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
		success: function(data){
			llenarNotas(data);
		},
		error: function(data){
			console.log('error al obtener los datos');
		}
	})
}

function llenarNotas(data){
	var textosFactura = data._embedded.textosFactura;
	var notas = $('#notas');
	for( var i=0; i<textosFactura.length; i++ ){
		var codigo = textosFactura[i].codigo;
		var txt1 = textosFactura[i].texto1!=null?textosFactura[i].texto1:'';
		var txt2 = textosFactura[i].texto2!=null?textosFactura[i].texto2:'';
		var txt3 = textosFactura[i].texto3!=null?textosFactura[i].texto3:'';
		var texto = zeroPad(codigo+'',3) + ' '  + txt1 + txt2 + txt3;
		notas.append($('<option>', {
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
		var forma = plazos[i].forma;
		var descripcion = plazos[i].forma + ' ' + plazos[i].descripcion;
		formaPago.append($('<option>', {
			text: descripcion,
			value: forma
		}));
	}
}

function llenarFecha(){
	var fechaActual = darFechaActual();
	$('#fecha').val(formatearFecha(darFechaActual()));
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
 * @param correrias: COrrerías en el sistemas obtenidas por medio del api.
 */
function llenarCorrerias( correrias )
{
	correrias = correrias._embedded.corrers;
	var comboCorreria = $("#correria");
	var option;
	
	for(i = 0; i < correrias.length; i++ )
	{ 
		option = $("<option>", { value: correrias[i].codigo, text: zeroPad( correrias[i].codigo, 3) +" " + correrias[i].nombre } );
		comboCorreria.append(option);
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
	
	for(i = 0; i < lineas.length; i++ )
	{ 
		option = $("<option>", { value: lineas[i].linea, 
								 text: zeroPad( lineas[i].linea, 2 ) + " " 
								 + zeroPad( lineas[i].rango1, 3 ) +"-" + zeroPad( lineas[i].rango2, 3 ) } );
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
	
	for(i = 0; i < vendedores.length; i++ )
	{ 
		option = $("<option>", { value: vendedores[i].codigo, text: vendedores[i].codigo + " " + vendedores[i].nombre } );
		comboVendedores.append(option);
	}
}