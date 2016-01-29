var codigo;
var nuevo = 'false';

$(document).ready(function(){
	nuevo = 'false';
	nuevo = GetURLParameter('nuevo');
	if(nuevo == 'false'){
		codigo = GetURLParameter('codigo');
		obtenerVendedor(codigo);
	}else{
		nuevavendedor();
		$('#eliminar').hide();
	}
	
});

function GetURLParameter(sParam){
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++){
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam){
            return sParameterName[1];
        }
    }
}

function obtenerVendedor(codigo){
	$.ajax({
		url: '../../api/vendedores/'+codigo,
		success: function(data){
			llenarCampos(data);
		},
		error: function(data){
			console.log('Error al obtener los datos');
		}
	});
}

function nuevavendedor(){
	$('#codigo').prop('readonly', false);
}

$("#tipo").keyup(function(){
	var text = $(this).val();
	var regex = new RegExp('V|R');
	if( !regex.test(text) )
		$(this).val('');
});

function llenarCampos( vendedor ){
	$('#codigo').val(vendedor.codigo);
	$('#tipo').val(vendedor.tipo);
	$('#nombre').val(vendedor.nombre);
	$('#direccion').val(vendedor.direccion);
	$('#telefonos').val(vendedor.telefonos);
	$('#identificacion').val(vendedor.identifica);
	$('#observacion-1').val(vendedor.observaci1);
	$('#observacion-2').val(vendedor.observaci2);
	$('#observacion-3').val(vendedor.observaci3);
}

function obtenerDatos( vendedor ){
	vendedor.codigo = $('#codigo').val();
	vendedor.tipo = $('#tipo').val();
	vendedor.nombre = $('#nombre').val();
	vendedor.direccion = $('#direccion').val();
	vendedor.telefonos = $('#telefonos').val();
	vendedor.identifica = $('#identificacion').val();
	vendedor.observaci1 = $('#observacion-1').val();
	vendedor.observaci2 = $('#observacion-2').val();
	vendedor.observaci3 = $('#observacion-3').val();
	delete vendedor._links;
	return vendedor;
}

$('#guardar-cambios').click(function(){
	$.ajax({
		url: '../../api/vendedores/A',
		success: function(vendedor){
			vendedor = obtenerDatos(vendedor);
			if( nuevo == 'false' ){
				$.ajax({
					type : "put",
					url : '../../api/vendedores/'+codigo,
					data : JSON.stringify(vendedor),
				    contentType: 'application/json; charset=utf-8',
					success : function(){
						window.location.href = "/mnuvenjm/";
					},
					error :function(data){
						alert('error al procesar los datos');
					}
				});
			}else if(nuevo == 'true'){
				$.ajax({
					type : "post",
					url : '../../api/vendedores',
					data : JSON.stringify(vendedor),
				    contentType: 'application/json; charset=utf-8',
					success : function(){
						window.location = "/mnuvenjm/";
					},
					error :function(data)
					{
						alert('error al procesar los datos');
					}
				});
			}
		},
		error: function(vendedor){
			console.log('Error al obtener los datos');
		}
	})
});

$('#eliminar').click(function(){
	$.ajax({
		type : "delete",
		url : '../../api/vendedor/'+codigo,
		success : function(){
			window.location.href = "/mnuactlajm7/";
		},
		error :function(){
			alert('error al procesar los datos');
		}
	});
});