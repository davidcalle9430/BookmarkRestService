/**
 * Archivo que arregla los tamaños de el tercer nivel de las listas basado en la anchura del padre
 */

var lists = $("nav ul ul");
lists.each(function(index){
	var tam = $(this).width();
	var subLists = $(this).find("ul");
	subLists.each(function(index){
		$(this).css({left : tam - 170});
	});
});