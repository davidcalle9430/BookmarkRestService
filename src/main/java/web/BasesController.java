package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasesController {
	
	@RequestMapping(value="/bases/")
	public String bases(){
		return "bases/bases";
	}
	@RequestMapping(value="/bases/editar/")
	public String basesEditar(){
		return "bases/baseseditar";
	}
	@RequestMapping(value="/bases/nuevo/")
	public String basesNuevo(){
		return "bases/basesnuevo";
	}
}
