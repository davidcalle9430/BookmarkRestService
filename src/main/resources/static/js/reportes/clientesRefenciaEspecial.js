
/**
 * funcion encargada de generar el reporte
 */
function generarReporte( ){
	
	function error( ){
		alert( "Error al generar el reporte" )
	}
	
	function correcto( ){
		$( "#descargar" ).attr( 'disabled' , 'disabled' );
		$( "#estado-reporte" ).text(" Generando reporte por favor espere ... ");
		revisarEstado( );
	}
	
	function actualizarEstado( estado ){
		
		if( estado.estado == "terminado"){
			
			$( "#estado-reporte" ).text(" Reporte Generado Correctamente ");
			var btnDescargar = $( "#descargar" ); 
			btnDescargar.removeAttr( 'disabled' );
			btnDescargar.attr( 'href'  , '/reportes/clientesRefenciaEspecial.pdf/' );
			btnDescargar.attr( 'target' , '_blank' );
			
		}else{
			setTimeout( revisarEstado , 500 ); // volver a revisar cada segundo
		}
	}
	
	function revisarEstado( ){
		
		getForObject( null , "/api/reportes/clientesrefenciaespecial/estado/" , actualizarEstado , error );
		
	}
	
	getForObject( null , "/api/reportes/clientesrefenciaespecial/" , correcto , error );
}