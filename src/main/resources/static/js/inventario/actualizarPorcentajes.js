var alFinal = false;
var pagina = 0;

function solicitarDatos(page){
	$.ajax({
		url: '/api/generos?page='+page,
		success: function(data){
			llenarTabla(data._embedded.generos);
			alFinal=false;
		},
		error: function(data){
			console.log('no funca');
		}
	});
}

function llenarTabla( generos ){
	for(var i=0; i<generos.length; i++){
		var codigo = $('<td>',{
			text:generos[i].codigo
		})
		var nombre = $('<td>',{
			text:generos[i].nombre 
		})
		var porcprec = $('<td>',{
			text:generos[i].porcprec
		})
		var fila = $('<tr>');
		fila.append(codigo);
		fila.append(nombre);
		fila.append(porcprec);
		$('tbody').append(fila);
	}
	
}

$(document).ready(function(){
	solicitarDatos(pagina);
	$(window).scroll(function() {
				if ($(window).scrollTop() + $(window).height() > $(document).height() - 50) {
					if (!alFinal) {
						alFinal = true;
						pagina++;
						solicitarDatos(pagina);
					}
				}
	});
});

