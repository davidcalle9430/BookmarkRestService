
$(document).ready(function(){
	iniciarFormulario();
})

/**
 * Se encarga de inicar lo compnentes del formualrio.
 * */
function iniciarFormulario()
{
	crearEncabezados();
	cargarLineas();
	$("table").on("click","tr", clicFila );	
}

/**
 * Función encargada de crear los encabezados de la tabla.
 */
function crearEncabezados() 
{
	var tabla = $("#lineas").first();
	var tr = $("<tr>");
	var codigo = $("<th>", {text :"Línea"});
	codigo.css("width","16.6%");
	var rango1 = $("<th>", { text : "Rango 1" });
	rango1.css("width","16.6%");
	var rango2 = $("<th>", { text : "Rango 2" });
	rango2.css("width","16.6%");
	var estado = $("<th>", { text : "Estado" });
	estado.css("width","16.6%");
	var descripcion = $("<th>", { text : "Descripción" });
	descripcion.css("width","16.6%");
	var permiterefespecial = $("<th>", { text: "Permite Referencia Especial" });
	permiterefespecial.css("width","16.6%");
	
	tr.append(codigo);
	tr.append(rango1);
	tr.append(rango2);
	tr.append(estado);
	tr.append(descripcion);
	tr.append(permiterefespecial);
	
	tabla.append(tr);
}


/**
 * Función encargada de cargar las líneas registradas en el sistema.
 */
function cargarLineas() 
{
	getForObject(null, "/api/lineas", llenarTabla );
}

/**
 * Se encarga de cargar los datos de cada línea del request ajax en una tabla HTML.
 * @paramas lineas: Las lineas a cargar.
 * 
 */
function llenarTabla (lineas) 
{
	lineasAcargar = lineas._embedded.lineas;
	var tabla = $("#lineas").first();
	for (var i = 0; i < lineasAcargar.length; i++) 
	{
		var linea = lineasAcargar[i];
		var tr = $("<tr>");
		
		var codigo = $("<td>", {text :linea.linea});
		var rango1 = $("<td>", { text : linea.rango1 });
		var rango2 = $("<td>", { text : linea.rango2 });
		var estado = $("<td>", { text : linea.estado });
		var descripcion = $("<td>", { text : linea.descripcion });
		var permiterefespecial = $("<td>", { text : linea.permiterefespecial });

		tr.append(codigo);
		tr.append(rango1);
		tr.append(rango2);
		tr.append(estado);
		tr.append(descripcion);
		tr.append(permiterefespecial);
		tabla.append(tr);
	}
}

/**
 * Se encarga de redirigir a la vista para editar la Linea seleccionada.
 */
function clicFila()
{
	var hijos = $(this).children();
	window.location = "editar/?codigo="+hijos[0].innerHTML;
}
