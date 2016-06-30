package restcontrollers;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import background.ClientesRefEspecialReport;
import resultclasses.EstadoReporte;;

@RestController
public class ClientesReportsRestControllers {
	
	final static Logger logger = Logger.getLogger( ClientesReportsRestControllers.class );
	
	@Autowired
	private ClientesRefEspecialReport reporteClienteRefEspecial;
	
	@RequestMapping( value = "/api/reportes/clientesrefenciaespecial/")
	public ResponseEntity<?> clientesRefenciaEspecial( @RequestParam( defaultValue = "pdf" ) String formato ){
		reporteClienteRefEspecial.generarReporte( formato );
		return new ResponseEntity<>( HttpStatus.OK );
	}
	
	@RequestMapping( value = "/api/reportes/clientesrefenciaespecial/estado/")
	public ResponseEntity< EstadoReporte > darEstadoReporteClientesRefEspcial( ){
		EstadoReporte estado = reporteClienteRefEspecial.getEstado();
		return new ResponseEntity<>( estado , HttpStatus.OK );
	}
	
	
	
}
