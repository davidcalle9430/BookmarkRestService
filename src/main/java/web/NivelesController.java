package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NivelesController {
	
	@RequestMapping(value="/mnuniveles/")
	public String mostrarNiveles(){
		return "niveles/niveles";
	}
	
	@RequestMapping(value="/mnuniveles/editar/")
	public String editarNivel(){
		return "niveles/niveleseditar";
	}
	
	@RequestMapping(value="/mnuniveles/nuevo/")
	public String nuevoNivel(){
		return "niveles/nivelesnuevo";
	}
	
	@RequestMapping(value="/mnunivelopc/")
	public String opcionesUsuarios(){
		return "niveles/opcionesusuarios";
	}
	
	@RequestMapping(value="/mnunivelopc/nuevo/")
	public String opcionesUsuariosCrear(){
		return "niveles/opcionesusuarioscrear";
	}
	
	@RequestMapping(value="/mnunivelopc/confirmar-eliminacion/")
	public String opcionesUsuariosEliminar(){
		return "niveles/opcionesusuarioseliminar";
	}
}
