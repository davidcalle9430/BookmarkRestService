package restcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import repositories.VentasOrganizacionRepository;

import sidic.entities.VentasseguimientoOrg;

/**
 * Clase que se encarga de extender la funcionalidad de spring data 
 * rest en la entidad Bodega consiste en queries más complejas que 
 * necesitan de clases  resultado intermedias para poder ser retornadas como un JSON.
 * @author David Suárez.
 *
 */

@RestController
public class VentasRestController 
{
	@Autowired
	private VentasOrganizacionRepository ventasRepository;
	
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/api/ventasorganizacion/")
	public Page<VentasseguimientoOrg> darVentasOrganizacion()
	{
		Page<VentasseguimientoOrg> retorno = ventasRepository.findAll(new PageRequest(10, 10));
		return retorno;
	}
}
