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
}
