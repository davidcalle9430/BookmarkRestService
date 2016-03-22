var articuloSeleccionado = null;

function error(data){}



/**
 * función que se ejecuta cuando carga el DOM
 */
$(document).ready(function(){
	var articulo = get("codigo");

	getForObject(null, "/api/articulos/"+ articulo , function(data){
		articuloSeleccionado = data;
		$("#modelovendedor").val( articuloSeleccionado.modelvendedor );
		$("#refvendedor").val( articuloSeleccionado.refvendedor );
		
	}, error ); // se obitiene la información del usuario y después se cargan los niveles
	
	$("#codigo").val( articulo );
	$("form").submit(function(ev){
		ev.preventDefault();
		articuloSeleccionado.refvendedor = $("#refvendedor").val();
		articuloSeleccionado.modelvendedor = $("#modelovendedor").val();
		putForObject(articuloSeleccionado, "/api/articulos/"+articulo, creacionExitosa, errorAlCrear);
	});
});
/**
 * función que se ejecuta cuando la creación es exitosa
 */
function creacionExitosa(){
	alert("Se ha modificado exitosamente");
	location.reload();
}
/**
 * función que se ejecuta cuando hay un error al crear
 */
function errorAlCrear(){
	alert("Hubo un error fatal en la modificación")
}