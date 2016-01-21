function solicitarDatos(){
	$.ajax({
		url: '/api/lineas',
		success: function(data){
			llenarTabla(data);
		},
		error: function(){
			
		}
	});
}

function llenarTabla( data ){
	var lineas = data._embedded.lineas;
	for( var i=0; i<lineas.length; i++ ){
		linea = $('<td>',{
			text: lineas[i].linea,
			class: 'linea'
		});
		rango1 = $('<td>',{
			text: lineas[i].rango1
		});
		rango2 = $('<td>',{
			text: lineas[i].rango2
		});
		var estadoText;
		lineas[i].estado=='D'?estadoText='Desactivado':estadoText='Activado';
		estado = $('<td>',{
			text: estadoText
		});
		descripción = $('<td>',{
			text: lineas[i].descripcion
		});
		var preText;
		lineas[i].permiterefespecial=='N'?preText='No':preText='Sí';
		permiterefespecial = $('<td>',{
			text: preText
		});
		var fila = $('<tr>');
		fila.append(linea);
		fila.append(rango1);
		fila.append(rango2);
		fila.append(estado);
		fila.append(descripción);
		fila.append(permiterefespecial);
		$('tbody').append(fila);
	}
}

$('.anadir-fila').click(function() {
	window.location.href = "/mnuactlajm7/editar/?nuevo=true";
});

$('table').on('click', 'tr', function() {
	var linea = $(this).find('.linea').text();
	window.location.href = "/mnuactlajm7/editar/?nuevo=false&linea="+linea;
});

$(document).ready(function(){
	solicitarDatos();
});