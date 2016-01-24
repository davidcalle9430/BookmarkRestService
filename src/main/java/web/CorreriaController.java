package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CorreriaController {
	/**
	 * metodo encargado de mostrar las correrias
	 * @return referencia al template de zonas
	 */
	@RequestMapping(value="/mnuactcorrjm/")
	public String darCorrerias(){
		return "correrias/correrias";
	}
	/**
	 * metodo encargado de mostrar el formulario  de nueva correría
	 * @return referencia el template de nueva correría
	 */
	@RequestMapping(value="/mnuactcorrjm/nuevo/")
	public String nuevaCorreria(){
		return "correrias/correriasnuevo";
	}
	
	/**
	 * metodo encargado de mostrar el formulario  de nueva correría
	 * @return referencia el template de nueva correría
	 */
	@RequestMapping(value="/mnuactcorrjm/editar/")
	public String editarCorreria(){
		return "correrias/correriaseditar";
	}
}
