package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientesController {

	@RequestMapping(value="/mnuclijm/", method = RequestMethod.GET)
	public String darClientes(){
		return "/clientes/clientes";
	}
	@RequestMapping(value="/mnuclijm/crear/")
	public String crearCliente(){
		return "/clientes/nuevocliente";
	}
	@RequestMapping(value="/mnuclijm/editar/")
	public String eliminarCliente(){
		return "/clientes/editarcliente";
	}
}
