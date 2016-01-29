package restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import repositories.NivelesRepository;
import sidic.entities.Niveles;

@RestController
public class NivelesRestController {
	@Autowired
	private NivelesRepository nivelesRespository;
	
	@RequestMapping(value="/api/niveles/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<?> actualizarNivel(@RequestBody Niveles nivel){
		nivelesRespository.actualizarNivel(nivel.getNivelesPK().getNivel(), nivel.getDescripcion(), nivel.getFecha());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
