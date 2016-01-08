
/**
 * 
 */
var usaurio = null;
var objUsuario = null;
$(document).ready(function(){
	usuario = get("Usuario");
	$.ajax({
		url : "/api/users/search/findOneByUsuario?usuario="+usuario,
		success : function(data){
			llenarDatoFormulario("usuario", data.usuario);
			llenarDatoFormulario("password", data.password);
			llenarDatoFormulario("nivel", data.nivel);
			llenarDatoFormulario("activado", data.activado);
			llenarDatoFormulario("maxdias", data.maxdias);
			llenarDatoFormulario("diasalerta", data.diasalerta);
			llenarDatoFormulario("indicadorNuevo", data.indicadorNuevo);
			llenarDatoFormulario("fechapassword", data.fechapassword);
			llenarDatoFormulario("fecha", data.fecha);
			llenarDatoFormulario("maxdias", data.maxdias);
			llenarDatoFormulario("empresa", data.empresa);
		},
		error : function(data){
			alert("El usuario no pudo se encontrado");
			window.location = "/configuracion/usuarios/";
		}
	});
	
	var forma = $("form").first();
	forma.submit(function(ev){
		ev.preventDefault();
		var forma = $("form").first();
		var aObjeto = $(forma).serializeObject();
		console.log("el obj es " +JSON.stringify(aObjeto));
		$.ajax({
			data : JSON.stringify(aObjeto),
			contentType: 'application/json; charset=utf-8',
			type: "put",
			url : "/api/users/" + usuario,
			success : function(data){
				alert("Usuario editado correctamente");
				window.location = "/configuracion/usuarios/";
			},
			error : function(data){
				alert("Error al editar el usuario");
			}
		});
	});
});