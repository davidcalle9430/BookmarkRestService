var alFinal = false;
var pagina = 0;
var generos = null;
var row_antes = null;
var row_antes_copia = null;
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
			console.log('error al obtener los datos');
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
			text:generos[i].codigo,
			class: 'codigo'
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
 * Función oyente de evento de clic sobre la fila de una tabla
 * cuando hay clic se reemplaza la etiqueta <p> por etiquetas
 * que corresponden a un cuadro de texto y un boton de guardar
 * los eventos producidos por este boton no se manejan en esta clase
 * */
$('table').on('click', 'tr', function() {
	row = $(this);
	if( row_antes != null && row_antes_copia!=null ){
		row_antes.find('.row').replaceWith(row_antes_copia.find('.porcprec'));
	}
	row_antes = row;
	row_antes_copia = row.clone();
    var codigo = row.find('.codigo');
    var porcprec = row.find('.porcprec');
    porcprec.replaceWith(
		     "<div class=\"row\">"
		    +"   <div class=\"large-2 columns\">"
		    +"      <div class=\"row collapse\">"
		    +"         <div class=\"small-10 columns\">"
		    +"            <input class=\"porcprec-input\" type=\"text\" value=\""+porcprec.text()+"\">"
		    +"         </div>"
		    +"         <div class=\"small-2 columns\">"
		    +"            <a class=\"button postfix guardar-btn\">Guardar</a>"
		    +"         </div>"
		    +"      </div>"
		    +"   </div>"
		    +"</div>"
    	);
   row.find('.porcprec-input').focus();
});

/*
 * Manejo de eventos producidos por el botón guardar,
 * */
$('table').on('click', '.guardar-btn', function() {
	var codigo = $(this).closest('tr').find('.codigo').text();
	var input  = $(this).closest('tr').find('.porcprec-input');
	$.ajax({
		url : '/api/generos/'+codigo,
		success: function(genero){
			nuevo_valor = input.val();
			if( nuevo_valor != genero.porcprec ){
				genero.porcprec = nuevo_valor;
				$.ajax({
					type : "put",
					url : '/api/generos/'+codigo,
					data : JSON.stringify(genero),
				    contentType: 'application/json; charset=utf-8',
					success : function(){
						row.find('.row').replaceWith($('<p>',{
								text: nuevo_valor,
								class: 'porcprec text-left'
							}));
					},
					error :function(data)
					{
						alert(error);
					}
				});
			}else{
				row.find('.row').replaceWith($('<p>',{
					text: genero.porcprec,
					class: 'porcprec text-left'
				}));
			}
		},
		error: function(){
			console.log('error al ingresar los datos');
		}
	});	
});


/**
 * Acciones a ejecutar cuando se terminen de cargar los elementos en la
 * pantalla (html, css). En este caso se ejecuta un codigo que permite
 * carga la información por partes según se vayan viendo y solicitando. 
 * */
var head = $("thead"); // busca los headers de la tabla
var columnas = 3; // numero de columnas de la tabla
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
				if(head.position().top -$(this).scrollTop() < 0 ){
					head.css("position", "fixed");
					head.css("top", "0px");
					head.css("width", "90vw");
					head.find("th").each(function(el){
						$(this).css("width", 90 / columnas + "vw")
					});
					$('table').find("td").each(function(el){
						$(this).css("width", 90 / columnas + "vw")
					});
				}else{
					head.css("position", "");
				}
	});
});

