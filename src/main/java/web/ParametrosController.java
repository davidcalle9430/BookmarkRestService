package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParametrosController {
	@RequestMapping("/mnuparjm/")
	public String editarParametros(){
		return "parametros/parametros";
	}
}
