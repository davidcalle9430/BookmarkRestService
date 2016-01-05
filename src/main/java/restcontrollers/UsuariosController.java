package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	@RequestMapping(value="/api/usuarios/{usuario}/", produces ="application/json", method = RequestMethod.GET)
	public Usuarios darUsuario(@PathVariable String usuario){
		return usuarioRepository.findOneByUsuario(usuario).orElseGet(null);
	}
	@RequestMapping(value="/api/usuarios/{usuario}/", produces="application/json", method = RequestMethod.PUT)
	public ResponseEntity<?> editarUsuario(@RequestBody Usuarios usuario){
		Usuarios seleccionado = usuarioRepository.findOneByUsuario(usuario.getUsuario()).get();
		if( usuario.getPassword()  == null || usuario.getPassword().length() < 1 ){
			usuario.setPassword(seleccionado.getPassword());
		}
		usuarioRepository.save(usuario);
		return new ResponseEntity<Usuarios>(HttpStatus.OK);	
	}
	@RequestMapping(value="/api/usuarios/{usuario}/", produces="application/json", method = RequestMethod.DELETE)
	public ResponseEntity<?> borrarUsuario(@RequestBody Usuarios usuario){
		usuarioRepository.delete(usuario);
		return new ResponseEntity<Usuarios>(HttpStatus.OK);	
	}
	@RequestMapping(value="/api/usuarios/", method = RequestMethod.POST)
	public ResponseEntity<?> crearUsuario(@RequestBody Usuarios usuario){
		Empresas impordisa = new Empresas(1);
		usuario.setEmpresas(impordisa);
		usuario.setEmpresa(1);
		try{
			usuario = usuarioRepository.save(usuario);
		}catch(Exception e){
			return new ResponseEntity<Usuarios>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Usuarios>(usuario, HttpStatus.CREATED);	
	}
	
	
}
