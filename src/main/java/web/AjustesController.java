package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjustesController {
	
	
	@RequestMapping(value="/mnudebdcjm/")
	public String notasDebitoCreditoCartera( ){
		return "ajustes/notasdecartera";
	}
	
	@RequestMapping( value = "/mnundcavjm/" )
	public String notasDebitoCreditoAcumVentas( ){
		return "ajustes/notasdebitocreditoacumventas";
	}
	
	@RequestMapping( value = "/mnundcrvjm/" )
	public String notasDCReporteVentas( ){
		return "ajustes/notasdcreporteventas";
	}
	
	@RequestMapping( value = "/CalCostoImpordisa/")
	public String calcularcostoimpordisa( ){
		return "ajustes/calcularcostoimpordisa";
	}
	
	@RequestMapping( value = "/mnuajcucjm/")
	public String corregircostoimpordisa( ){
		return "ajustes/corCostoImpordisa";
	}
	
	@RequestMapping( value  = "/mnuajpresjm/" )
	public String ajustarPreciosAPartirdeArticulo( ){
		return "ajustes/ajustarprecioaarituclo";
	}
	
	
}
