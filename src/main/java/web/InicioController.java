package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value="/")
public class InicioController 
{
	@RequestMapping(value={"/inicio/","","/"})
	public String inicio()
	{
		return "inicio";
	}
	@RequestMapping(value="/jm/")
	public String menuJM()
	{
		return "jm";
	}
}
