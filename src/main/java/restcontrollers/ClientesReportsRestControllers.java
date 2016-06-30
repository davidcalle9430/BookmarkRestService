package restcontrollers;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import background.ClientesRefEspecialReport;;

@RestController
public class ClientesReportsRestControllers {
	
	final static Logger logger = Logger.getLogger( ClientesReportsRestControllers.class );
	
	@Autowired
	private ClientesRefEspecialReport reporteClienteRefEspecial;
	
	@RequestMapping( value = "/api/reportes/clientesrefenciaespecial/")
	public ResponseEntity<?> clientesRefenciaEspecial( ){
		reporteClienteRefEspecial.generarReporte( "pdf" );
		return new ResponseEntity<>( HttpStatus.OK );
	}
	
	
	
}
