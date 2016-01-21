package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProveedoresController {

	@RequestMapping("/Mnulprov/")
	public String darProveedores(){
		return "proveedores/proveedores";
	}
}
