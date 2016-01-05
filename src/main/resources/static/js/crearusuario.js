/**
 * 
 */
// obtenido de https://css-tricks.com/snippets/jquery/serialize-form-to-json/
$.fn.serializeObject = function()
{
   var o = {};
   var a = this.serializeArray();
   $.each(a, function() {
       if (o[this.name]) {
           if (!o[this.name].push) {
               o[this.name] = [o[this.name]];
           }
           o[this.name].push(this.value || '');
       } else {
           o[this.name] = this.value || '';
       }
   });
   return o;
};
$.ajaxSetup({
	  xhrFields: {
	    withCredentials: true
	  }
});

$(document).ready(function(){
	var forma = $("form").first();
	var loader = $(".loader").first();
	loader.css({display : "none"})
	forma.submit(function(ev){
		ev.preventDefault();
		loader.css({display:"block"})
		var aObjeto = $(forma).serializeObject();
		console.log(aObjeto);
		$.ajax({
			type : "post",
			url : "/api/usuarios/",
			data : JSON.stringify(aObjeto),
		    contentType: 'application/json; charset=utf-8',
			success : function(data){ 
				alert("Usuario creado exitosamente");
				loader.css({display:"none"});
				window.location = "/configuracion/usuarios/";
			},
			error : function(data){ 
				alert("Error al crear el usuario");
				loader.css({display:"none"});
			}
		});
	});
});