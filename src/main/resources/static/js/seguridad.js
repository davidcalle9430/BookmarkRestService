/**
 * Documento que se encarga de agregar la segunda cada de seguridad a al aplicación
 */
var documentBody = document.getElementsByTagName("body");
$( "#password-dialog" ).dialog();

$(document).foundation();
var popup = new Foundation.Reveal($('#password-modal'));
popup.open();
function seguridadvalidarContra2(){
	var contra = $("#seg-password").val();
	var xmlhttp = new XMLHttpRequest();
	var url = "/api/nfact/1";
	xmlhttp.onreadystatechange = function() {
	    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
	        var obj = JSON.parse(xmlhttp.responseText);
	        if( obj.clavec == contra){
	        	popup.close();
	        }else{
	        	alert("Clave incorrecta");
	        }
	    }
	};
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
}

