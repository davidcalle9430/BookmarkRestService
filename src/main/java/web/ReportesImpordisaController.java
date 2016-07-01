package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ReportesImpordisaController {

	
	@RequestMapping(value = "/mnucarti/", method = RequestMethod.GET )
	public String reporteClientesRefenciaEspecial( ){
		return "reportes/impordisa/consultacardexarticulo";
	}
	
	@RequestMapping(value = "/mnucarti/mostrar/", method = RequestMethod.GET )
	public String reporteClientesRefenciaEspecialMostrar( ){
		return "reportes/impordisa/consultacardexarticulomostrar";
	}
}
