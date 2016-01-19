package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LineasController {
	
	@RequestMapping(value="/mnuactlajm/")
	public String listarLineas()
	{
		return "lineas/lineas";
	}
	
	@RequestMapping(value="/mnuactlajm/editar/")
	public String editarLinea(){
		return "lineas/editarLinea";
	}
	
	@RequestMapping(value="/mnuactlajm/agregar/")
	public String agregarLinea(){
		return "lineas/editarLinea";
	}
}

