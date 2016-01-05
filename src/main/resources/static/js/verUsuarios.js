/**
 * 
 */
function insertarUsuarioEnTabla(tabla, usuario){
	var html = "<tr>";
	html += "<td>"+ usuario.usuario+ "</td>";
	html += "<td>"+ usuario.fechapassword + "</td>";
	html += "<td>"+ "<a style='color:blue;' href=/configuracion/editarusuario/?Usuario=" + usuario.usuario  +"> Editar Usuario </a></td>";
	html += "</tr>";
	tabla.append(html);
}

$(document).ready(function(){
	var tabla = $("table").first();
	$.ajax({
		url : "/api/users/?size=1000",
		success: function(data){
			var usuarios = data._embedded.users;
			for(var i = 0 ; i < usuarios.length ; i++ ){
				insertarUsuarioEnTabla(tabla, usuarios[i]);
			}
		}
	});
	
});