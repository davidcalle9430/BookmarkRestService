package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FacturacionController {

	@RequestMapping(value="/mnufaci/")
	public String crearFactura(){
		return "facturas/crearfactura";
	}
	@RequestMapping(value = "/mnuanufi/")
	public String anularFactura(){
		return "facturas/anularfactura";
	}
	
	@RequestMapping(value="/mnutextosfacturas/")
	public String textosFacturas(){
		return "facturas/textosfactura";
	}
	@RequestMapping(value="/mnutextosfacturas/nuevo/")
	public String textosFacturasNuevo(){
		return "facturas/textosfacturanuevo";
	}
	@RequestMapping(value="/mnutextosfacturas/editar/")
	public String textosFacturasEditar(){
		return "facturas/textosfacturaeditar";
	}
}
	