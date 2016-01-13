var elegido = null;
var genero = null;

function llenarValores(data){
	$("#codigo").val(data.codigo);
	$("#nombre").val(data.nombre);
	$("#nombrei").val(data.nombrei);
	$("#tipart").val(data.tipart);
	$("#iva").val(data.iva);	
}
/**
 * 
 */
$(document).ready(function(){
	elegido = get("codigo");
	getForObject(null, "/api/generos/"+elegido, function(data){
		elegido = data;
		llenarValores(elegido);
	}, function(data){
		alert("Error, No existe el elemento buscado");
	});
	$("#editar").submit(function(ev){
		ev.preventDefault();
		var obj = $("#editar").serializeObject();
		for(var atributo in obj){
			elegido[atributo] = obj[atributo];
		}
		var correcto = function(data){
			alert("Actualizado correctamtente");
			window.location.reload();
		}
		var error = function(data){
			alert("Error al actualizar");
		}
	    putForObject(elegido, "/api/generos/"+elegido.codigo,correcto, error);
	});
	$("#eliminar").submit(function(ev){
		ev.preventDefault();
		var url = "/api/generos/"+elegido.codigo;
		var seguro = confirm("Seguro de eliminar este artículo?");
		if(seguro){
			$.ajax({
				type : "delete",
				url : url,
			    contentType: 'application/json; charset=utf-8',
				success : function(data){
					alert("eliminado correctamente");
				},
				error :function(data){
					alert("Error al eliminar");
				}
			});
		}
		
	})
	
});