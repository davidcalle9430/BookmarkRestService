package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProveedoresController {

	@RequestMapping("/Mnulprov/")
	public String darProveedores(){
		return "proveedores/proveedores";
	}
	/**
	 * la razón por la que este tiene este mapping es porque 
	 * no existe en la base de datos, parece que no tiene permisos y 
	 * el programador no la creó antes por pereza
	 * @return
	 */
	@RequestMapping("/Mnulprov/actualizacion/")
	public String darProveedoresActualizacion(){
		return "proveedores/actualizacion";
	}
}
