package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import repositories.UsuarioRepository;
import sidic.entities.Empresas;
import sidic.entities.Usuarios;
@RestController
public class UsuariosController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/api/usuarios/", method = RequestMethod.GET)
	public List<Usuarios> mostrarTodosLosUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@RequestMapping(value="/api/usuarios/", method = RequestMethod.POST)
	public ResponseEntity<?> crearUsuario(Usuarios usuario){
		Empresas impordisa = new Empresas(1); // toca quemado por la "fachada" de la bd
		usuario.setEmpresas(impordisa);
		usuario.setEmpresa(1);
		try{
			usuario = usuarioRepository.save(usuario);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Usuarios>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Usuarios>(usuario, HttpStatus.CREATED);	
	}
	
	
}
