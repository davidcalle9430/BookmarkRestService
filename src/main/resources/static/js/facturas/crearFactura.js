var esEspecial = "S";
var NFact = null;
var ciudad = null;
var cliente = null;
var cambiados = new Object();


$(document).ready(function(){
	$("#cambia-precios").val("N");
	$("#precio").val("M");
	obtenerFilaSelec();
//	$("form").submit(guardarCambios);
	cargarFormasPago();
	cargarNotas();
	cargarNFact();
	llenarFecha();
	cargarCliente();
	cargarLineas();
	cargarVendedores();
})



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
		obtenerAtributosArticulo(trSelec);
	});
}

function obtenerAtributosArticulo( trSelec)
{
	var codigoConFormato = $(trSelec).find("#codigo").val();
	$(trSelec).find("#nombre").val("");
	$(trSelec).find("#referencia").val("");
	$(trSelec).find("#precio").val("");
	$(trSelec).find("#cantidad").val("");
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
	 var nuevoInputNprecio= $("<input>",{id:"cantidad", type:"number", required:"required"});
	 var nuevoInputPrecio= $("<input>",{id:"precio", type:"number",readonly:"readonly"});
	 
	 nuevoTdCodigo.append(nuevoInputCodigo);
	 nuevoTdNombre.append(nuevoInputNombre);
	 nuevoTdReferencia.append(nuevoInputReferencia);
	 nuevoTdNprecio.append(nuevoInputNprecio);
	 nuevoTdPrecio.append(nuevoInputPrecio);
	 
	 nuevoTr.append(nuevoTdCodigo);
	 nuevoTr.append(nuevoTdNombre);
	 nuevoTr.append(nuevoTdReferencia);
	 nuevoTr.append(nuevoTdNprecio);
	 nuevoTr.append(nuevoTdPrecio);
	 
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

function cargarCliente(){
	$('#codigo-1').blur(function(event){
		var codigo = $(this).val();
		if( codigo !==  "" )
		{
			$.ajax({
				url: '/api/clientes/'+codigo,
				success: function(data){
					cliente = data;
					completarCliente(data);
				},
				error: function(data){
					completarCliente(null);
				}
			})
		}
		else
		{
			$("#codigo-2").removeAttr("readonly");
			$("#nit").removeAttr("readonly");
			$("#direccion").removeAttr("readonly");
			$("#ciudad-1").removeAttr("readonly");
		}
	})
}


function cargarVendedores(){
	getForObject(null, "/api/vendedores", function(vendedores){
		vendedores = vendedores._embedded.vendedores;
		var select = $("#vendedor");
		for(var i = 0; i < vendedores.length; i++){
			var option = $("<option>", {value : vendedores[i].codigo, text: vendedores[i].nombre});
			select.append(option);
		}
	});
}

function cargarLineas(){
	getForObject(null,"/api/lineas", function(lineas){
		lineas = lineas._embedded.lineas;
		var select = $("#linea");
		for(var i = 0; i < lineas.length; i++){
			 var option = $("<option>",{value:lineas[i].linea, text: zeroPad(lineas[i].linea,3) + "  " + zeroPad(lineas[i].rango1,3) + "-"+  zeroPad(lineas[i].rango2,3)});
			 select.append(option);
		}
	})
}

function completarLinea(cliente){
	getForObject(null, "/api/clientes/"+cliente.codigo+"/linea", function(linea){
		$("#linea").val(linea.linea);
	});
}

function completarCorreria(cliente){
	getForObject(null, "/api/clientes/"+cliente.codigo+"/codcorr", function(corr){
		$("#correria").append($("<option>", { text : zeroPad(corr.codigo, 3) + " " + corr.nombre }));
	});
}

function completarVendedor(cliente){
	getForObject(null, "/api/clientes/"+cliente.codigo+"/vendedor", function(vendedor){
		$("#vendedor").val(vendedor.codigo);
	});
}

function completarCliente(cliente){
	if( cliente != null ){
		getForObject({codigo:cliente.codigo}, "/api/especia/search/findByCodigo", completarEspecial );
		$('#codigo-2').val(cliente.proptario);
		$('#direccion').val(cliente.direccion);
		$('#almacen').val(cliente.razsoc);
		$('#nit').val( cliente.nit != null? cliente.nit : (cliente.cc != null? cliente.cc : "0"));
		completarLinea(cliente);
		completarCorreria(cliente);
		completarVendedor(cliente);
		completarCiudad(cliente.codigo);
	}else{
		alert("Este código no esta asociado a algún código");
	}
}

//NO SABEMOS PARA QU SE USA
function completarEspecial( especias )
{
	especias = especias._embedded.especias;
	if( especias.length == 0 )
	{
		esEspecial = "N";
	}
}


function completarCiudad( cliente ){
	$.ajax(
	{
		url: "/api/clientes/"+cliente+"/ciudad",
		success:function(data)
				{
					$("#ciudad-1").val(data.codigo);	
					$("#ciudad-2").val(data.ciudad);
				},
		error: function(data)
			{
				$("#ciudad-2").val('Ciudad no registrada en la base de datos');
				$("#ciudad-1").val("0");	
			}
	})
}

function cambioDeFormaPago() 
{
	var formaPago = $("#forma-pago").val();
	if(formaPago == "CON")
	{
		$("#labelDiasPago").attr("style", "display:none");
	}
	else
	{
		$("#labelDiasPago").attr("style", "display:block");
	}
}


function cambioDeNotas()
{
	var notas = $("#notas").val();
	getForObject(null,"/api/textosFactura/"+notas,completarNotas);
}


function completarNotas( notaSelec )
{
	$("#dias").val(notaSelec.dias);
	$("#porcentaje").val(notaSelec.porcentaje);
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

function llenarFactIva(data){
	$('#factura').val(data+1);
}

function cargarNotas (){
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
			alert('Error al obtener los datos');
		}
	})
}

function llenarFormasPago( formasPago ){
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
	$('#fecha').val(darFechaActual());
}

