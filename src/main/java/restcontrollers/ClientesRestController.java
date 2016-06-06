package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import repositories.EspeciaRepository;
import sidic.entities.Especia;
import sidic.entities.EspeciaPK;


@RestController
public class ClientesRestController {

	@Autowired
	private EspeciaRepository especiaRepo;
	
	@RequestMapping( value = "/api/especia", method = RequestMethod.PUT , produces="application/json" )
	public ResponseEntity<?> guardarCambioPrecio( @RequestBody Especia cliente){
		Especia especia = especiaRepo.findOne( new EspeciaPK( cliente.getCodigo() , cliente.getArticulo() ) );
		if( especia == null ){
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		especia.setPrecio( cliente.getPrecio() );
		especiaRepo.save( especia );
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
