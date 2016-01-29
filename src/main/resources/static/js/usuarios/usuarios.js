$(document).ready(function(){
	tabla();
});

function tabla(){
	$.ajax({
		url: '/api/users',
		success: function(data){
			var usuarios = data._embedded.users;
			llenarTabla(usuarios);
		},
		error: function(){
			
		}
	});
}

function llenarTabla(usuarios){
	for(var i=0; i<usuarios.length; i++){
		var usuario = $('<td>',{
			text: users[i].usuario
		});
		console.log(usuarios[i].usuario);
		var nivel = $('<td>',{
			text: usuarios[i].nivel
		});
		var nombreNivel = $('<td>',{
			text: 'ToDo' //getNombreNivel(usuarios[i].nivel);
		});
		var maxDias = $('<td>',{
			text: usuarios[i].maxdias
		});
		var diasAlerta = $('<td>',{
			text: usuarios[i].diasalerta
		});
	}
}

function getNombreNivel(nivel){
	$.ajax({
		url: '/api/niveleses',
		async: false,
		success: function(data){
			var niveles = data._embedded.niveleses;
			for(var i=0; i<niveles.length; i++){
				console.log(niveles[i]);
			}
		},
		error: function(){
			
		}
	});
}