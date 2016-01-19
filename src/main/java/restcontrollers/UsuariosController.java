package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import repositories.UsuarioRepository;
import sidic.entities.Empresas;
import sidic.entities.Usuarios;
/**
 * clase encargada de extender la funcionalidad de spring data-rest para la entidad Usuario
 * @author david
 *
 */
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
		return usuarioRepository.findOneByUsuario(usuario);
	}
	@RequestMapping(value="/api/usuarios/{usuario}/", produces="application/json", method = RequestMethod.PUT)
	public ResponseEntity<?> editarUsuario(@RequestBody Usuarios usuario){
		Usuarios seleccionado = usuarioRepository.findOneByUsuario(usuario.getUsuario());
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
	
	/**
	 * método que retorna la información del usuario que está actualmente
	 * autenticado
	 * @return información del usaurio acutal
	 */
	@RequestMapping(value="/api/seguridad/autenticacion/", produces="application/json", method = RequestMethod.GET)
	public Usuarios darInformacionUsuario(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return usuarioRepository.findOneByUsuario(username);
	}
	
	/**
	 * método que se encarga de cambiar la contraseña del usuario actual, se encarga de verificar que
	 * no se otro usuario el que esté intentando acceder
	 * @param usuario
	 * @return código de estatus dependiendo del camino de ejecución
	 */
	@RequestMapping(value="/api/seguridad/autenticacion/", produces="application/json", method = RequestMethod.POST)
	public ResponseEntity<?> cambiarContrasenia(@RequestBody Usuarios usuario){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Usuarios actual = usuarioRepository.findOneByUsuario(username);
		actual.setPassword(usuario.getPassword());
		if(!actual.getUsuario().equals(usuario.getUsuario())){
			return new ResponseEntity<Usuarios>(HttpStatus.UNAUTHORIZED);
		}
		try{
			usuarioRepository.save(usuario);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Usuarios>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Usuarios>(HttpStatus.ACCEPTED);
	}
	
}
