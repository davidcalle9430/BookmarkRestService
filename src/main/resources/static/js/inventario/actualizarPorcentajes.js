var alFinal = false;
var pagina = 0;
/*
 * Realiza los llamados ajax, de ser exitoso el llamado
 * llena la tabla, la idea es que como está separado por páginas, se
 * solicite una página cada vez que se acabe la información mostrada.
 * */
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

/*
 * Dado un genero, llena la tabla con la información obtenida desde
 * la base de datos.
 */
function llenarTabla( generos ){
	for(var i=0; i<generos.length; i++){
		var codigo = $('<td>',{
			text:generos[i].codigo
		})
		var nombre = $('<td>',{
			text:generos[i].nombre 
		})
		var porcprec = $('<p>',{
			text:generos[i].porcprec,
			class: 'porcprec text-left'
		})
		var tr_porcprec = $('<td>');
		tr_porcprec.append(porcprec);
		var fila = $('<tr>');
		fila.append(codigo);
		fila.append(nombre);
		fila.append(tr_porcprec);
		$('tbody').append(fila);
	}
	
}
/*
 * clase oyente de evento de clic sobre la fila de una tabla
 * cuando hay clic se reemplaza la etiqueta <p> por etiquetas
 * que corresponden a un cuadro de texto y un boton de guardar
 * los eventos producidos por este boton no se manejan en esta clase
 * */
$('table').on('click', 'tr', function() {
    var prev = $(this).find('.porcprec').text();
    $(this).find('.porcprec').replaceWith("<div class=\"row\">"
    +"<div class=\"large-4 columns\">"
    +"<div class=\"row collapse\">"
    +"  <div class=\"small-10 columns\">"
    +"     <input type=\"text\" value=\""+prev+"\">"
    +"  </div>"
    +"  <div class=\"small-2 columns\">"
    +"     <a class=\"button postfix guardar-btn\">Guardar</a>"
    +"  </div>"
    +"</div>"
  +"</div>");
});

$('table').on('click', '.guardar-btn', function() {
	console.log('clic');
});
/*
 * Acciones a ejecutar cuando se terminen de cargar los elementos en la
 * pantalla (html, css). En este caso se ejecuta un codigo que permite
 * carga la información por partes según se vayan viendo y solicitando. 
 * */
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

