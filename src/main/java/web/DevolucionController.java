package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DevolucionController 
{

	@RequestMapping(value="/mnudevi/")
	public String devolucion()
	{
		return "devoluciones/agregarDevolucion";
	}
	
	@RequestMapping(value="/mnudevjm/")
	public String devolucionJM()
	{
		return "devoluciones/agregarDevolucionJM";
	}
}
