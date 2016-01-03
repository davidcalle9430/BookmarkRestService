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

import entities.Usuario;
import entities.Rol;
import repositories.AccountRepository;
import repositories.RoleRepository;
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
	
	/**
     * Repositorio de cuentas, encargado de la persistencia en la Base de Datos
     */
	@Autowired
	private AccountRepository accountRepository;
	/**
     * Repositorio de roles, encargado de la persistencia en la Base de Datos
     */
	@Autowired
	private RoleRepository roleRepository;
	
	 /**
	   * Este método se usa para mostrar el formulario 
	   * encargado de la creación de usuarios
	   * @param model conjunto de atributos que se le pasan a la vista
	   * @return String retorna el nombre de la vista asociada.
	   */
	@RequestMapping(value = "/CrearUsuario/", method = RequestMethod.GET)
	public String NewUser(Model model) {
		model.addAttribute("user", new Usuario());
		List<Rol> roles = roleRepository.findAll();
		model.addAttribute("roles", roles);
		return "CrearUsuario";
	}
	 /**
	   * Este método se usa para obtener el formulario llenado por el usuario
	   * , es el encargado de la creación de usuarios
	   * @param user usuario creado y enviado desde la vista
	   * @return RedirectView clase encargada de redirigir al usuario a la lista de usuarios.
	   */
	@RequestMapping(value = "/CrearUsuario/", method = RequestMethod.POST)
	public RedirectView createUser(@ModelAttribute("user") Usuario user) {
		accountRepository.save(user);
		return new RedirectView("/Usuarios/");
	}
	 /**
	   * Este método se usa para mostrar el formulario de todos los usuarios
	   * @param model conjunto de atributos que se le pasan a la vista
	   * @return String retorna el nombre de la vista asociada.
	   */
	@RequestMapping(value = "/Usuarios/", method = RequestMethod.GET)
	public String showUsers(Model model) {
		List<Usuario> users = accountRepository.findAll();
		model.addAttribute("users", users);
		return "Usuarios";
	}

	 /**
	   * Este método se usa para mostrar el formulario 
	   * encargado de la edición de los usuarios
	   * @param model conjunto de atributos que se le pasan a la vista
	   * @param username  nombre de usuario que se va a editar
	   * @return String retorna el nombre de la vista asociada.
	   */
	@RequestMapping(value = "/EditarUsuario/", method = RequestMethod.GET)
	public String editUser(@RequestParam String username, Model model) {
		Optional<Usuario> oAcount = accountRepository.findByUsername(username);
		if (oAcount.isPresent()) {
			Usuario account = oAcount.get();
			model.addAttribute("account", account);
			List<Rol> roles = roleRepository.findAll();
			model.addAttribute("roles", roles);
		}
		return "EditarUsuario";
	}
	/**
	   * Este método se usa para obtener el formulario llenado por el usuario
	   * , es el encargado de la edición de los usuarios
	   * @param account usuario creado y enviado desde la vista con los valores modificados
	   * @return RedirectView clase encargada de redirigir al usuario a la lista de usuarios.
	   */
	@RequestMapping(value = "/EditarUsuario/", method = RequestMethod.POST)
	public RedirectView postCreateUser(@ModelAttribute("account") Usuario account) {
		if (account.getPassword() == null || account.getPassword().length() < 1) {
			Usuario before = accountRepository.findOne(account.getId());
			Rol role = roleRepository.findOne(account.getRole().getRole());
			account.setRole(role);
			account.setPassword(before.getPassword());
		}
		accountRepository.save(account);
		return new RedirectView("/Usuarios/");
	}
	
	/**
	   * Este método se usa para mostrar el formulario 
	   * encargado de la eliminación de usuarios
	   * @param model conjunto de atributos que se le pasan a la vista
	   * @return String retorna el nombre de la vista asociada.
	   */
	//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('WOASD') ")
	@RequestMapping(value = "/EliminarUsuario/", method = RequestMethod.GET)
	public String selectUserToDelete(@RequestParam String username, Model model) {
		Optional<Usuario> oAccount = accountRepository.findByUsername(username);
		if (oAccount.isPresent()) {
			Usuario account = oAccount.get();
			model.addAttribute("account", account);
		}
		return "BorrarUsuario";
	}
	/**
	   * Este método se usa para obtener el formulario llenado por el usuario
	   * , es el encargado de la eliminacipon del usuario
	   * @param account usuario creado y enviado para eliminar
	   * @return RedirectView clase encargada de redirigir al usuario a la lista de usuarios.
	   */
	@RequestMapping(value = "/EliminarUsuario/", method = RequestMethod.POST)
	public RedirectView deleteUser(@ModelAttribute("user") Usuario account) {
		account = accountRepository.findOne(account.getId());
		account = accountRepository.findOne(account.getId());
		accountRepository.delete(account);
		return new RedirectView("/Usuarios/");
	}
}
