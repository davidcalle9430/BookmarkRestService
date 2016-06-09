package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositories.ImportacionesRepository;

import sidic.entities.Importaciones;

/**
 * Clase que se encarga de extender la funcionalidad de spring data 
 * rest en la entidad Bodega consiste en queries más complejas que 
 * necesitan de clases  resultado intermedias para poder ser retornadas como un JSON.
 * @author David Suárez.
 *
 */

@RestController
public class ImportacionesRestController {
	
	@RequestMapping(value="/api/importaciones/")
	public List<Importaciones> darImportaciones(){
		return importacionesRepository.findAll();
	}
	
	@Autowired
	ImportacionesRepository importacionesRepository;
}
