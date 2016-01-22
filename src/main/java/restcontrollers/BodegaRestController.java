package restcontrollers;


import java.util.List;

import resultclasses.Bodega;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import repositories.CardexiRepository;
import repositories.GeneroRepository;
/**
 * Clase que se encarga de extender la funcionalidad de spring data rest en la entidad Compra
 * consiste en queries más complejas que necesitan de clases  resultado intermedias para poder ser retornadas como un JSON
 * @author David Suárez.
 *
 */
@RestController
public class BodegaRestController {
	
	@Autowired CardexiRepository controCardex;
	@Autowired GeneroRepository controGenero;
	
	
	@RequestMapping(value="/api/bodega/", method = RequestMethod.PUT )
	public ResponseEntity<?> guardaEnBodega( @RequestBody List<Bodega> bodegas)
	{
		for (Bodega bodega : bodegas ) 
		{
			controCardex.save( bodega.getCardex( ) );
			controGenero.save( bodega.getGenero( ) );
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	
	
}
