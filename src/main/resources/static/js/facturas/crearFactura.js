var NFact = null;
var ciudad = null;
var cliente = null;

$(document).ready(function(){
	cargarFormasPago();
	cargarNotas();
	cargarNFact();
	llenarFecha();
	cargarCiudad();
	cargarCliente();
})

function cargarCliente(){
	$('#codigo-1').keyup(function(event){
		var codigo = $(this).val();
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
	})
}

function completarCliente(cliente){
	if( cliente != null ){
		$('#codigo-2').val(cliente.proptario);
		$('#direccion').val(cliente.direccion);
		$('#almacen').val(cliente.razsoc);
		$('#nit').val(cliente.nit)
	}else{
		$('#cliente-2').val('cliente no encontrado');
	}
}

function cargarCiudad(){
	$("#ciudad-1").keyup(function(event) {
		var codigo = $(this).val();
		$.ajax({
			url: "/api/ciudades/"+codigo,
			success:function(data){
				ciudad = data;
				completarCiudad(ciudad);
			},
			error: function(data){
				completarCiudad(null);
			}
		})
	})
}

function completarCiudad( ciudad ){
	if( ciudad!=null){
		$("#ciudad-2").val(ciudad.ciudad);
	}else{
		$("#ciudad-2").val('Ciudad no encontrada');
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
			console.log('error al obtener los datos');
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

