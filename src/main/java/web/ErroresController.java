package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErroresController {
	
	@RequestMapping(value="/errores/404")
	public String error404( ){
		return "errores/404";
	}
}