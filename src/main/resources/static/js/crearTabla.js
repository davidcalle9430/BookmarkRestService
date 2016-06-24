/* 
 * función encargada la tabla a partir de una lista de elementos
 * Debe tener al menos un elemento para que funcione
 * recibe el atributo de la lista de propiedades que se quiere usar
 */

function cargarTabla( lista ) {
	
	dobleClic( manejador );
	
	var tabla = $( "table" ).first( );
	for (var i = 0; i < lista.length; i++) {
		
		var elemento = lista[ i ];
		var tr = $( "<tr>" );
		
		var codigo = $( "<td>" );
		var razSoc = $( "<td>" );
		var direccion = $( "<td>" );
		var telefono = $( "<td>" );
		var ciudad = $( "<td>" );
		var nit = $( "<td>" );
		
		codigo.html( elemento[ 'codigo' ] );
		razSoc.html( elemento[ 'razsoc' ] );
		direccion.html( elemento[ 'direccion' ] );
		telefono.html( elemento[ 'telefono' ] );
		ciudad.html( elemento[ 'ciudad' ].ciudad );
		nit.html( elemento[ 'nit' ] );
		
		tr.append( codigo );
		tr.append( razSoc );
		tr.append( direccion );
		tr.append( telefono );
		tr.append( ciudad );
		tr.append( nit )
		tabla.append( tr );
	}
}

/**
 * Función encargada de traer los clientes por ajax
 */

function cargarClientes( ) {
		$.ajax({
			url : "/api/clientes/?sort=codigo&size=9999999&projection=factura",
			success : function(data) {
				cargarTabla( data._embedded.clientes );
			}
		})
}

/*
 * Función que se encarga de añadir un handler para cada fila
 * 
 */

function dobleClic( manejador ) {
	
	$("body").on( "click" , "tr" , manejador );

}

var manejador = function() {
	var hijos = $(this).children();
	console.log(hijos);
	window.location = "editar/?codigo=" 
		+ hijos[0].innerHTML;
}

/**
 * función encargada de crear una tabla
 * 
 * 
 */
$(document).ready(function() {
	
	var body = $("body").first();
	
	var tablaDom = $("table").first();
	
	cargarClientes(  );
	
});
