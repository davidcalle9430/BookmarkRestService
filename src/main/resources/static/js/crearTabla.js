
/* 
 * función encargada la tabla a partir de una lista de elementos
 * Debe tener al menos un elemento para que funcione
 * recibe el atributo de la lista de propiedades que se quiere usar
 */
function cargarTabla(lista, propiedades, aMostrar){
	var primero = lista[0];
	var tr = $("<tr>");
	for(atributo in primero){
		if(propiedades.indexOf(atributo) != -1){
			var th = $("<th>");
			th.html(aMostrar[propiedades.indexOf(atributo)]);
			tr.append(th);
		}
	}
	var tabla = $("table").first();
	tabla.append(tr);
	
	for( var i = 0; i < lista.length; i++ ){
		var elemento = lista[i];
		var tr = $("<tr>");
		for(atributo in elemento){
			if(propiedades.indexOf(atributo) != -1){
				var td = $("<td>");
				td.html(elemento[atributo]);
				tr.append(td);
			}
		}
		tabla.append(tr);
	}
}
/**
 * función encargada de crear una tabla
 * 
 * 
 */
$(document).ready(function(){
	var body = $("body").first();
	var table = $("<table>", {id : "tabla"});
	var tabla = $("table").first();
	var loader = $(".loader").first();
	loader.css({display : "block"});
	body.append(table);
	var tablaDom = $("table").first();
	$.ajax({
		url : "/api/clientes/?size=999999",
		success : function(data){
			cargarTabla(data._embedded.clientes,["codigo", "razsoc","direccion", "telefono","ciudad","nit"],["Código","Razón Social","Dirección",  "Teléfono","Ciudad"," NIT"]);
			loader.css({display : "none"});
		}
	})
});

