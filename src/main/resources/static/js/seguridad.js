var documentBody = document.getElementsByTagName("body");
documentBody[ 0 ].style.display ="none";
var contra = window.prompt("¿Contraseña?");

var xmlhttp = new XMLHttpRequest();
var url = "/api/nfact/1";

xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var obj = JSON.parse(xmlhttp.responseText);
        if( obj.clavec == contra){
        	documentBody[ 0 ].style.display ="block";
        }else{
        	alert("Clave incorrecta");
        	window.location.href="/";
        }
    }
};
xmlhttp.open("GET", url, true);
xmlhttp.send();