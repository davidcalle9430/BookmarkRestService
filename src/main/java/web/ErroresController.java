package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErroresController {
	
	@RequestMapping(value="/errores/401")
	public String unauthorized(){
		return "errores/401";
	}
	
	@RequestMapping(value="/errores/404")
	public String notFound(){
		return "errores/404";
	}
	
	@RequestMapping(value="/errores/500")
	public String internalServerError(){
		return "errores/500";
	}
}
