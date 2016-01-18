package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComprasController {
	
	@RequestMapping(value="/mnucomjm/")
	public String agregarCompra()
	{
		return "/compras/agregarCompra";
	}
	
	
}

