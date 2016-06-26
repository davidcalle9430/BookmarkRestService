/**
 * 
 */
var pagina = 0;
var alFinal = false;
function ajaxCall() {
	$.ajax({
		url : '/api/tipoOperacionBases?projection=tipo&size=9999999',
		success : function(data) {
			crearFila(data);
			alFinal = false;
			pagina++;
		},
		error : function(data) {
			console.log("Error al recuperar los datos");
		}
	})
}

function crearFila( bases ) {
	
	bases = bases._embedded.tipoOperacionBases;
	for (var i = 0; i < bases.length; i++) {
		
		var tr = $("<tr>");
		
		var columnaOperacion = $('<td>', {
			text : bases[i].tipooperacion1.codigo
		});
		
		var columnaNombre = $('<td>', {
			text : bases[i].tipooperacion1.nombre
		});
		
		var columnaImpuesto = $('<td>', {
			text : bases[i].tipooperacionbasesPK.impuesto
		});
		
		var columnaBase = $('<td>', {
			text : bases[i].base
		});
		
		var columnaPorcentaje = $('<td>', {
			text : bases[i].porcentaje
		});
		var columnaTipo = $('<td>', {
			text : bases[i].tipo ==	"1" ? "por cien" : "por mil"
		});
		
		tr.append(columnaOperacion);
		tr.append(columnaNombre);
		tr.append(columnaImpuesto);
		tr.append(columnaBase);
		tr.append(columnaPorcentaje);
		tr.append(columnaTipo);
		
		$('tbody').append(tr);
	}
}
function clicFila(){
	var hijos = $(this).children();
	window.location = "editar/?base="+hijos[0].innerHTML+"--"+hijos[2].innerHTML;
}

var head = $("thead"); // busca los headers de la tabla
var columnas = 6; // numero de columnas de la tabla
$( document ).ready( function( ) {
	
			ajaxCall();
			
			$("table").on("click","tr", clicFila);
});