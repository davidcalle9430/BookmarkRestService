package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticuloController {
	@RequestMapping(value="/mnuactacri/")
	public String actualizarArticulos(){
		return "/articulos/actualizararticulo";
	}
	@RequestMapping(value="/mnuajcsjm/")
	public String AjustarCantidadesSecuancialemente(){
		return "/articulos/ajustarNombres";
	}
	@RequestMapping(value="/mnuajcsjm/crear/")
	public String crearNuevo(){
		return "/articulos/agregarInglesEspanol";
	}
	@RequestMapping(value="/mnuajcsjm/editar/")
	public String editar(){
		return "/articulos/editarInglesEspanol";
	}
}
