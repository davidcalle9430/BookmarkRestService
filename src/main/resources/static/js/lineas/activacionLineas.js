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
			text: lineas[i].linea
		});
		rango1 = $('<td>',{
			text: lineas[i].rango1
		});
		rango2 = $('<td>',{
			text: lineas[i].rango2
		});
		estado = $('<td>',{
			text: lineas[i].estado
		});
		descripción = $('<td>',{
			text: lineas[i].descripcion
		});
		permiterefespecial = $('<td>',{
			text: lineas[i].permiterefespecial
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

$('.anadir-fila').click()

$(document).ready(function(){
	solicitarDatos();
});