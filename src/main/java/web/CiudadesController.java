package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CiudadesController {

	@RequestMapping(value="/mnuactciud/")
	public String ciudades(){
		return "ciudades/ciudades";
	}
	@RequestMapping(value="/mnuactciud/nuevo/")
	public String crearCiudad(){
		return "ciudades/ciudadescrear";
	}
	@RequestMapping(value="/mnuactciud/editar/")
	public String c(){
		return "ciudades/ciudadeseditar";
	}
}
