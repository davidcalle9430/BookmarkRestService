var seleccionado = null;
var cardexi = new Object();
/**
 * función encargada de poner los datos en el formulario
 */
var obtenerDatos = function(genero){
	seleccionado = genero;
	$("#nombre").val(genero.nombre);
	$("#codigo").val(genero.codigo);
	$("#cantBodega").val(genero.cantdisp);
}
/**
 * función que busca el gnero seleccionado
 */
function buscar(){
	var genero = get("codigo");
	getForObject(null,"/api/generos/"+genero, obtenerDatos);
}
var actualizacion = function(data){
	postForObject(cardexi, "/api/cardexi/", finActualizacion, error);
}
var finActualizacion = function(data){
	alert("Actualización completa");
}
var error = function(data){
	alert("Error al actualizar");
}
$(document).ready(function(){
	buscar();
	$("form").submit(function(ev){
		ev.preventDefault();	
		var obj = $(this).serializeObject();
		cardexi.codigo = obj.codigo;
		cardexi.fecha = darFechaActual();
		cardexi.tipo = obj.cantidad > obj.cantAnterior ? "E" : "S";
		cardexi.ajuste = obj.cantidad - obj.cantAnterior;
		if(cardexi.ajuste < 0){
			ajuste = ajuste * -1;
		}
		cardexi.documento = obj.documento;
		cardexi.ndoc = obj.ndoc;
		cardexi.cantidad = cardexi.ajuste;
		cardexi.saldo = obj.cantidad;
		seleccionado.cantdisp = obj.cantidad;
		putForObject(seleccionado, "/api/generos/"+seleccionado.codigo, actualizacion, error);
		
	})
});