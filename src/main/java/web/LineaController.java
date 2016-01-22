package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LineaController {
	@RequestMapping(value="/mnuactlajm7/")
	public String activacionLineas(){
		return "lineas/activacionLineas";
	}
	@RequestMapping(value="/mnuactlajm7/editar/")
	public String activacionLineasEditar(){
		return "lineas/activacionLineasEditar";
	}
	@RequestMapping(value="/mnuactlajm7/nuevo/")
	public String activacionLineasNuevo(){
		return "lineas/activacionLineasNuevo";
	}
}
