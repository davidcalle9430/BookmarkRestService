$(document).ready(function() {
	var url = window.location.href;
	var error = "error";
	if( !(url.indexOf(error) > -1) ){
		$('.alerta').hide();
	}
});