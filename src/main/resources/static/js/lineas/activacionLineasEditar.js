var nlinea = 0;
var nuevo = 'true';

$(document).ready(function(){
	nuevo = GetURLParameter('nuevo');
	if(nuevo == 'false'){
		nlinea = GetURLParameter('linea');
		obtenerLinea(nlinea);
	}else{
		nuevaLinea();
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

function obtenerLinea(nlinea){
	$.ajax({
		url: '../../api/lineas/'+nlinea,
		success: function(data){
			llenarCampos(data);
		},
		error: function(data){
			console.log('Error al obtener los datos');
		}
	});
	return linea;
}

function nuevaLinea(){
	var url;
	$.ajax({
		url: '../../api/lineas/',
		success: function(data){
			var tam = data._embedded.lineas.length;
			if (tam <= 0)
				tam = 1;
			data = data._embedded.lineas[tam-1];
			llenarCampos(data);
		},
		error: function(data){
			console.log('Error al obtener los datos');
		}
	});
	return linea;
}

function llenarCampos(linea){
	var estado = $('input:radio[name=estado]');
	var permiterefespecial = $('input:radio[name=permiteRefEspecial]');
	if(nuevo == 'true'){
		$('#linea').val(++linea.linea);
		estado.filter('[value=activado]').prop('checked', true);
		permiterefespecial.filter('[value=si]').prop('checked', true);
		return;
	}
	$('#linea').val(linea.linea);
	$('#rango1').val(linea.rango1);
	$('#rango2').val(linea.rango2)
	if(linea.estado == 'D'){
        estado.filter('[value=desactivado]').prop('checked', true);
    }else if(linea.estado == 'A'){
		estado.filter('[value=activado]').prop('checked', true);
	}
	if(linea.permiterefespecial == 'N'){
		permiterefespecial.filter('[value=no]').prop('checked', true);
	}else if(linea.permiterefespecial == 'S'){
		permiterefespecial.filter('[value=si]').prop('checked', true);
	}
	$('#descripcion').val(linea.descripcion);
}

$('#guardar-cambios').click(function(){
	$.ajax({
		url: '../../api/lineas/'+nlinea,
		success: function(linea){
			linea = actualizarCampos(linea);
			if( nuevo == 'false' ){
				$.ajax({
					type : "put",
					url : '../../api/lineas/'+nlinea,
					data : JSON.stringify(linea),
				    contentType: 'application/json; charset=utf-8',
					success : function(){
						window.location.href = "/mnuactlajm7/";
					},
					error :function(data){
						alert('error al procesar los datos');
					}
				});
			}else if(nuevo == 'true'){
				$.ajax({
					type : "post",
					url : '../../api/lineas',
					data : JSON.stringify(linea),
				    contentType: 'application/json; charset=utf-8',
					success : function(){
						window.location.href = "/mnuactlajm7/";
					},
					error :function(data)
					{
						alert('error al procesar los datos');
					}
				});
			}
		},
		error: function(linea){
			console.log('Error al obtener los datos');
		}
	})
});

function actualizarCampos(linea){
	linea.linea = $('#linea').val();
	linea.rango1 = $('#rango1').val();
	linea.rango2 = $('#rango2').val();
	var estado = $("input[name=estado]:checked").val();
	if(estado == 'activado'){
        linea.estado = 'A'
    }else if(estado == 'desactivado'){
    	linea.estado = 'D'
	}
	var permiterefespecial = $("input[name=permiteRefEspecial]:checked").val();
	if(permiterefespecial == 'no'){
		linea.permiterefespecial = 'N';
	}else if(permiterefespecial == 'si'){
		linea.permiterefespecial = 'S';
	}
	linea.descripcion = $('#descripcion').val();
	return linea;
}

$('#eliminar').click(function(){
	$.ajax({
		type : "delete",
		url : '../../api/lineas/'+nlinea,
		success : function(){
			window.location.href = "/mnuactlajm7/";
		},
		error :function(){
			alert('error al procesar los datos');
		}
	});
});

