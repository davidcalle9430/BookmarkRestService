package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TiposOperacionController 
{
	
	@RequestMapping(value="/tipoOperacion/")
	public String listarLineas()
	{
		return "tipoOperacion/tiposOperacion";
	}
	
	@RequestMapping(value="/tipoOperacion/editar/")
	public String editarLinea(){
		return "tipoOperacion/editarTipoOperacion";
	}
	
	@RequestMapping(value="/tipoOperacion/agregar/")
	public String agregarLinea(){
		return "tipoOperacion/editarTipoOperacion";
	}
}

