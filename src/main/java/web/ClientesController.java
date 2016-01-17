package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * Clase encarga de hacer el enlace entre los templates y la URI
 * los nombres de los menus vienen de la base de datos
 * @author David
 *
 */
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
	
	@RequestMapping(value="/mnuclirei/")
	public String clientesReferenciaEspecial(){
		return "/clientes/clientesReferenciaEspecial";
	}
	@RequestMapping(value="/mnuclirei/editar/")
	public String clientesReferenciaEspecialEditar(){
		return "/clientes/clientesReferenciaEspecialEditar";
	}

}
