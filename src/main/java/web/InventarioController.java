package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InventarioController {
	@RequestMapping(value="/mnuajcandcjm/")
	public String ajustarCantidadesCodigo(){
		return "/inventario/ajustarcantidadescodigo";
	}
	
	@RequestMapping(value="/mnuajupi/")
	public String ajustarPreciosCodigo(){
		return "/inventario/ajustarPreciosCodigo";
	}
}

