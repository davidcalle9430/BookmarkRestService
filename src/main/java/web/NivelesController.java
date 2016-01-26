package web;

import org.springframework.stereotype.Controller;

@Controller
public class NivelesController {

	public String mostrarNiveles(){
		return "niveles/niveles";
	}
}
