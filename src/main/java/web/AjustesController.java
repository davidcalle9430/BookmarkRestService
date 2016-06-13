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
	public String notasDebitoCreditoAcumVentas(){
		return "ajustes/notasdebitocreditoacumventas";
	}
	
	@RequestMapping( value = "/mnundcrvjm/" )
	public String notasDCReporteVentas(){
		return "ajustes/notasdcreporteventas";
	}
	
}
