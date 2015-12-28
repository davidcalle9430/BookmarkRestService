package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositories.ImportacionesRepository;

import sidic.entities.Importaciones;
@RestController
public class ImportacionesController {
	
	@RequestMapping(value="/api/importaciones/")
	public List<Importaciones> darImportaciones(){
		return importacionesRepository.findAll();
	}
	
	@Autowired
	ImportacionesRepository importacionesRepository;
}
