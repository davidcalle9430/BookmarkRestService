package restcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import repositories.VentasOrganizacionRepository;

import sidic.entities.VentasseguimientoOrg;

@RestController
public class VentasController {
	@Autowired
	private VentasOrganizacionRepository ventasRepository;
	
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/api/ventasorganizacion/")
	public Page<VentasseguimientoOrg> darVentasOrganizacion(){
		Page<VentasseguimientoOrg> retorno = ventasRepository.findAll(new PageRequest(10, 10));
		return retorno;
	}
}
