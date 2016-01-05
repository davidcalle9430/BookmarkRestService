package web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
/**
* Controlador del usuario
* Clase encargada de crear, elminar, actualizar y eliminar usuarios
*
* @author  David Calle
* @version 1.0
* @since   2015-12-14
*/

import ch.qos.logback.access.pattern.RequestMethodConverter;
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
}
