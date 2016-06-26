function tabla( ){
	$.ajax({
		url:'/api/vendedores?size=99999',
		success:function(data){
			llenar(data._embedded.vendedores);
		},
		error: function(){
			console.log('error al obtener los datos');
		}
	})
}

function llenar(vendedores){
	for (var i = 0; i < vendedores.length; i++) {
		var codigo = $('<td>',{
			text: vendedores[i].codigo,
			class: 'codigo'
		});
		var nombre = $('<td>',{
			text: vendedores[i].nombre
		});
		var tipo = $('<td>',{
			text: vendedores[i].tipo
		});;
		var direccion = $('<td>',{
			text: vendedores[i].direccion
		});
		var telefonos = $('<td>',{
			text: vendedores[i].telefonos
		});
		var observacion_1 = $('<td>',{
			text: vendedores[i].observaci1
		});
		
		var fila = $('<tr>');
		fila.append(codigo);
		fila.append(nombre);
		fila.append(tipo);
		fila.append(direccion);
		fila.append(telefonos);
		fila.append(observacion_1);
		
		$('tbody').append(fila);
	}
}

function clicFila(){
	var codigo = $(this).find('.codigo').text();
	window.location = '/mnuvenjm/editar/?nuevo=false&codigo='+codigo;
}

$('#nuevo').click(function(){
	window.location = '/mnuvenjm/editar/?nuevo=true';
});

var head = $("thead"); // busca los headers de la tabla
var columnas = 6; // numero de columnas de la tabla
$(document).ready(function() {
	
			tabla( );
						
			$("table").on("click","tr", clicFila);
});