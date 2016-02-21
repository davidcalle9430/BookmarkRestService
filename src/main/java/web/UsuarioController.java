package web;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* Controlador del usuario
* Clase encargada de crear, elminar, actualizar y eliminar usuarios
*
* @author  David Calle
* @version 1.0
* @since   2015-12-14
*/
	
@Controller
public class UsuarioController {
	
	@RequestMapping(value = "/configuracion/crearusuario/", method = RequestMethod.GET)
	public String vistaCrearUsuario(){
		return "vistacrearusuario";
	}
	@RequestMapping(value = "/configuracion/usuarios/", method = RequestMethod.GET)
	public String verTodosLosUsuarios(){
		return "vistausuarios";
	}
	@RequestMapping(value="/configuracion/editarusuario/", method = RequestMethod.GET)
	public String editarUsuario(){
		return "vistaeditarusuario";
	}

	
	@RequestMapping(value="/mnucampass/")
	public String cambiarCredenciales(){
		return "usuarios/cambiarcredenciales";
	}

	@RequestMapping(value="/mnuusuarios/", method = RequestMethod.GET)
	public String usuarios(){
		return "usuarios/usuarios";
	}
	
	@RequestMapping(value="/mnuusuarios/nuevo/", method = RequestMethod.GET)
	public String usuariosCrear(){
		return "usuarios/usuariosnuevo";
	}
	
	@RequestMapping(value="/mnuusuarios/editar/", method = RequestMethod.GET)
	public String usuariosEditar(){
		return "usuarios/usuarioseditar";
	}
	
}
