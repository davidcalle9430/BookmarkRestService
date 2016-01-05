/**
 * 
 */
function insertarUsuarioEnTabla(tabla, usuario){
	var html = "<tr>";
	html += "<td>"+ usuario.usuario+ "</td>";
	html += "<td>"+ usuario.fechapassword + "</td>";
	html += "<td> <a style='color:blue;'>"+ "Editar Usuario"+ "<a></td>";
	html += "</tr>";
	tabla.append(html);
}

$(document).ready(function(){
	$.ajax({
		url : "/api/users",
		success: function(data){
			var usuarios = data._embedded.users;
			for(var i = 0 ; i < usuarios.length ; i++ ){
				insertarUsuarioEnTabla(tabla, usuarios[i]);
			}
		}
	});
	
});