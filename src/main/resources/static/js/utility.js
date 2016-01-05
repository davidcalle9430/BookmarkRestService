/**
 * función encargada de serilizar un formulario y volverlo un objeto JS
 */
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
/**
 * cambiar la configuración de XHR de Jquery
 */
$.ajaxSetup({
	  xhrFields: {
	    withCredentials: true
	  }
});


