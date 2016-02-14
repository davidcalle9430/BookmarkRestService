package restcontrollers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import repositories.MenusRepository;
import repositories.NivelesRepository;
import repositories.RolesYMenusRepository;
import repositories.UsuarioRepository;
import sidic.entities.Menus;
import sidic.entities.MenusPK;
import sidic.entities.Niveles;
import sidic.entities.Rolesymenus;
import sidic.entities.RolesymenusPK;
import resultclasses.RolesMenuNivel;
@RestController
public class NivelesRestController {
	
	@Autowired
	private NivelesRepository nivelesRespository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private MenusRepository menuRepository;
	
	
	@Autowired
	private RolesYMenusRepository rmRepository;
	
	@RequestMapping(value="/api/niveles/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<?> actualizarNivel(@RequestBody Niveles nivel){
		nivelesRespository.actualizarNivel(nivel.getNivelesPK().getNivel(), nivel.getDescripcion(), nivel.getFecha());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/api/opcionesniveles/")
	public List<RolesMenuNivel> darOpcionesNivel(){
		Query q;
		q = em.createQuery("select new resultclasses.RolesMenuNivel ( "
				+ "n.nivelesPK.nivel, "
				+ "n.descripcion, "
				+ "rm.rolesymenusPK.menu, "
				+ "m.descripcion ) "
				+ "from Rolesymenus rm, Niveles n, Menus m "
				+ "where rm.rolesymenusPK.rol = n.nivelesPK.nivel and rm.rolesymenusPK.menu = m.menusPK.menu "
				+ "order by n.nivelesPK.nivel");
		List<RolesMenuNivel> retorno = q.getResultList();
		return retorno;
	}
	
	@RequestMapping(value="/api/rolesymenus/", method= RequestMethod.POST)
	public ResponseEntity<?> agregarRolMenu(@RequestBody Map<String, String> elegidos){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Menus menu = menuRepository.findOneByMenusPK_menu(elegidos.get("menu"));
		Rolesymenus nuevo = new Rolesymenus();
		RolesymenusPK pk = new RolesymenusPK();
		pk.setEmpresa(1);
		pk.setMenu(elegidos.get("menu"));
		pk.setRol(Long.parseLong(elegidos.get("nivel")));
		nuevo.setRolesymenusPK(pk);
		nuevo.setUsuario(username);
		nuevo.setFecha(new Date());
		nuevo.setMenus(menu);
		try{
			rmRepository.save(nuevo);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
