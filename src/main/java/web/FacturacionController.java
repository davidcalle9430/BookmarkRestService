package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FacturacionController {

	@RequestMapping(value="/mnufaci/")
	public String crearFactura(){
		return "/facturas/crearfactura";
	}
	@RequestMapping(value = "/mnuanufi/")
	public String anularFactura(){
		return "/facturas/anularfactura";
	}
}
	