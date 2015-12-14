package web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import entities.Account;
import entities.Role;
import repositories.AccountRepository;
import repositories.RoleRepository;

@Controller
public class UserController {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "/CrearUsuario/", method = RequestMethod.GET)
	public String NewUser(Model model) {
		model.addAttribute("user", new Account());
		List<Role> roles = roleRepository.findAll();
		model.addAttribute("roles", roles);
		return "CrearUsuario";
	}

	@RequestMapping(value = "/CrearUsuario/", method = RequestMethod.POST)
	public RedirectView createUser(@ModelAttribute("user") Account user) {
		System.out.println(user.toString() + " " + user.getRole().toString());
		accountRepository.save(user);
		return new RedirectView("/Usuarios/");
	}

	@RequestMapping(value = "/Usuarios/", method = RequestMethod.GET)
	public String showUsers(Model model) {
		List<Account> users = accountRepository.findAll();
		model.addAttribute("users", users);
		return "Usuarios";
	}

	@RequestMapping(value = "/EditarUsuario/", method = RequestMethod.GET)
	public String editUser(@RequestParam String username, Model model) {
		Optional<Account> oAcount = accountRepository.findByUsername(username);
		if (oAcount.isPresent()) {
			Account account = oAcount.get();
			model.addAttribute("account", account);
			List<Role> roles = roleRepository.findAll();
			model.addAttribute("roles", roles);
		}
		return "EditarUsuario";
	}

	@RequestMapping(value = "/EditarUsuario/", method = RequestMethod.POST)
	public RedirectView postCreateUser(@ModelAttribute("account") Account account) {
		System.out.println("entra " + account.toString());
		if (account.getPassword() == null || account.getPassword().length() < 1) {
			Account before = accountRepository.findOne(account.getId());
			Role role = roleRepository.findOne(account.getRole().getRole());
			account.setRole(role);
			account.setPassword(before.getPassword());
		}
		System.out.println("Entra a editar al usuario ");
		System.out.println(account.toString());
		accountRepository.save(account);
		return new RedirectView("/Usuarios/");
	}

	@RequestMapping(value = "/EliminarUsuario/", method = RequestMethod.GET)
	public String selectUserToDelete(@RequestParam String username, Model model) {
		Optional<Account> oAccount = accountRepository.findByUsername(username);
		if (oAccount.isPresent()) {
			Account account = oAccount.get();
			model.addAttribute("account", account);
		}
		return "BorrarUsuario";
	}

	@RequestMapping(value = "/EliminarUsuario/", method = RequestMethod.POST)
	public RedirectView deleteUser(@ModelAttribute("account") Account account) {
		account = accountRepository.findOne(account.getId());
		accountRepository.delete(account);
		return new RedirectView("/Usuarios/");
	}
}
