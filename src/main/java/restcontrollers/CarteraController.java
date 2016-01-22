package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import sidic.entities.Cartera;
import repositories.CarteraRepository;

/**
 * Clase que se encarga de extender la funcionalidad de spring data 
 * rest en la entidad Cartera consiste en queries más complejas que 
 * necesitan de clases  resultado intermedias para poder ser retornadas como un JSON.
 * @author David Suárez.
 *
 */

@RestController
public class CarteraController 
{

	
	@RequestMapping(value="/api/cartera/")
	public Page<Cartera> todosLosArticulos(@RequestParam(defaultValue="0") Integer pagina)
	{
		Page<Cartera> pag = carteraRepository.findAll(new PageRequest(pagina, 30));
		return pag;
	}
	
	@RequestMapping(value="/api/cartera/{codigo}/")
	public List<Cartera> darDetalleCartera(@PathVariable Long codigo)
	{
		return carteraRepository.findByCarteraPK_Codigo(codigo);
	}
	
	@Autowired
	private CarteraRepository carteraRepository;
}
