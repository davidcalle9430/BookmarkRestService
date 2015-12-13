package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import entities.Account;
import repositories.AccountRepository;

@Controller
public class UserController {
	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping(value="/CrearUsuario/", method=RequestMethod.GET)
	public String NewUser(Model model){
		model.addAttribute("user", new Account());
		return "CrearUsuario";
	}
	
	@RequestMapping(value="/CrearUsuario/", method=RequestMethod.POST)
	public RedirectView createUser( @ModelAttribute("user") Account user){
		System.out.println(user.toString());
		accountRepository.save(user);
		return new RedirectView("/Usuarios/");
	}
	@RequestMapping(value="/Usuarios/", method=RequestMethod.GET)
	public String showUsers(Model model){
		List<Account> users = accountRepository.findAll();
		model.addAttribute("users" , users);
		return "Usuarios";
	}
	
	
}
