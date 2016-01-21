package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * controlador encargador de enrutar la url a los templatess adecuados
 * @author David Calle
 *
 */
@Controller
public class ZonasController {
	/**
	 * metodo encargado de mostrar las zonas
	 * @return referencia al template de zonas
	 */
	@RequestMapping(value="/mnuactzonjm/")
	public String darZonas(){
		return "zonas/zonas";
	}
	/**
	 * metodo encargado de mostrar el formulario  de nueva zona
	 * @return referencia el template de nueva zona
	 */
	@RequestMapping(value="/mnuactzonjm/nuevo/")
	public String nuevaZona(){
		return "zonas/zonasNuevo";
	}
	
	/**
	 * metodo encargado de mostrar el formulario  de nueva zona
	 * @return referencia el template de nueva zona
	 */
	@RequestMapping(value="/mnuactzonjm/editar/")
	public String editarZona(){
		return "zonas/zonasEditar";
	}
}
