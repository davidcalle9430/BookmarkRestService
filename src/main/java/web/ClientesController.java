package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientesController {

	@RequestMapping(value="/clientes/", method = RequestMethod.GET)
	public String darClientes(){
		return "clientes";
	}
}
