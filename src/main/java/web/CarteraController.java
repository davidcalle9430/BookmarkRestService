package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarteraController {

	
	@RequestMapping(value="/mnureccjm/")
	public String AjustarCantidadesSecuancialemente(){
		return "cartera/recuperacioncartera";
	}
	
	
}
