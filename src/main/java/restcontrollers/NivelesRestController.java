package restcontrollers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import repositories.NivelesRepository;
import sidic.entities.Niveles;

import resultclasses.RolesMenuNivel;
@RestController
public class NivelesRestController {
	@Autowired
	private NivelesRepository nivelesRespository;
	
	@PersistenceContext
	private EntityManager em;
	
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
				+ "where rm.rolesymenusPK.rol = n.nivelesPK.nivel and rm.rolesymenusPK.menu = m.menusPK.menu ");
		List<RolesMenuNivel> retorno = q.getResultList();
		return retorno;
	}
}
