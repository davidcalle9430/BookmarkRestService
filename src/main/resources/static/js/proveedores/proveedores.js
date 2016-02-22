/**
 * 
 */
var head = $("thead");
var columnas = 2;
$(document).ready(function(){
	iniciarFormulario();
	$(window).scroll(function() {
		if(head.position().top -$(this).scrollTop() < 0 ){
			head.css("position", "fixed");
			head.css("top", "0px");
			head.css("width", "90vw");
			head.find("th").each(function(el){
				$(this).css("width", 100 / columnas + "vw")
			});
		}else{
			head.css("position", "");
			head.css("top", "");
		}
	});

});


/**
 * Se encarga de inicar lo compnentes del formualrio.
 * */
function iniciarFormulario()
{
	cargarLineas();
}


/**
 * Función encargada de cargar las líneas registradas en el sistema.
 */
function cargarLineas() 
{
	getForObject(null, "/api/proveedores/", llenarTabla, function(data){alert("Error")});
}

/**
 * Se encarga de cargar los datos de cada línea del request ajax en una tabla HTML.
 * @paramas lineas: Las lineas a cargar.
 * 
 */
function llenarTabla (proveedores) 
{
	var tabla = $("#lineas").first();
	for (var i = 0; i < proveedores.length; i++) 
	{
		var proveedor = proveedores[i];
		var tr = $("<tr>");
		
		var numReg = $("<td>", {text :proveedor.numReg});
		var procedencia = $("<td>", { text : proveedor.procedenc });
		
		tr.append(procedencia);
		tr.append(numReg);

		tabla.append(tr);
	}
}
