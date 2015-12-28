package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repositories.UsuarioRepository;

import sidic.entities.Usuarios;
@RestController
public class UsuariosController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@RequestMapping(value="/api/usuarios/")
	public List<Usuarios> mostrarTodosLosUsuarios(){
		return usuarioRepository.findAll();
	}
	
	
}
