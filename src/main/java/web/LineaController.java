package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LineaController {
	@RequestMapping(value="/mnuactlajm7/")
	public String activacionLineas(){
		return "/lineas/activacionLineas";
	}
}
