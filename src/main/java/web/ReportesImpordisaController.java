package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ReportesImpordisaController {

	
	@RequestMapping( value = "/mnuckari/" , method = RequestMethod.GET )
	public String reporteClientesRefenciaEspecial( ){
		return "reportes/impordisa/consultacardexarticulo";
	}
	
	@RequestMapping( value = "/mnuckari/mostrar/" , method = RequestMethod.GET )
	public String reporteClientesRefenciaEspecialMostrar( ){
		return "reportes/impordisa/consultacardexarticulomostrar";
	}
	
	@RequestMapping( value = "/mnucarti/" , method = RequestMethod.GET )
	public String reporteInformacionArticulo( ){
		return "reportes/impordisa/consultainfoarticulos";
	}
	
	@RequestMapping( value = "/mnucarti/mostrar/" , method = RequestMethod.GET )
	public String reporteInformacionArticuloMostrar( ){
		return "reportes/impordisa/consultainfoarticulosmostrar";
	}
	
	@RequestMapping( value = "/mmnulcosijm/" , method = RequestMethod.GET )
	public String costoDeVentas( ){
		return "reportes/impordisa/costodeventas";
	}
	
}
