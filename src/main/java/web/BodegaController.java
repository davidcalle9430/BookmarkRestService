package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BodegaController {

	@RequestMapping(value = "/mnuenti/")
	public String agregarABodega(){
		return "/bodega/agregarabodega";
	}
}
