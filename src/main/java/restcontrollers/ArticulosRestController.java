package restcontrollers;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import resultclasses.ArticuloGenero;
import resultclasses.ArticuloGeneroCostoDTO;
import resultclasses.CardexFactura;
import resultclasses.ClienteArticuloEspecial;
import resultclasses.Proveedor;
import services.ArticuloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import repositories.ArticuloRepository;
import repositories.EspeciaRepository;
import sidic.entities.Articulo;
import sidic.entities.Especia;;
/**
 * Clase que se encarga de extnder la funcionalidad de spring data rest en la entidad artìculo
 * consiste en queries más complejas que encesitan de  clases  resultado intermedias para poder ser retornadas como un JSON
 * @author david
 *
 */
@RestController
public class ArticulosRestController 
{
	
	
	@Autowired
	private EspeciaRepository especiaRepository;
	
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Autowired
	private ArticuloService articuloService;
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * query sin parametros debido a errrores por los caracteres especiales
	 * @param ndoc
	 * @param fecha
	 * @return
	 */
	@RequestMapping(value="/prueba/")
	public List<CardexFactura> test(@RequestParam("numerodoc")Long ndoc, @RequestParam("fecha")String fecha){
		
		Query query = em.createNativeQuery("select a.codigo, g.nombre, a.referencia, a.precio*cardex.cantidad as valor from articulo a, cardex, genero g where a.codigo = cardex.codigo 	and LEFT(LPAD(a.codigo,6,'0'),3) = LPAD(g.codigo,3,'0') and ndoc = "+ndoc+" and str_to_date('"+fecha+"', '%Y\\-%m\\-%d') order by cardex.consec");
		@SuppressWarnings("unchecked")
		
		List<Object[]> resultados = query.getResultList();
		ArrayList<CardexFactura> cfList = new ArrayList<>();
		
		for (Object[] objects : resultados) {
			CardexFactura cf = new CardexFactura();
			cf.setCodigo(objects[0]!=null?(long)Double.parseDouble(objects[0].toString()):null);
			cf.setNombre(objects[1]!=null?objects[1].toString():null);
			cf.setReferencia(objects[2]!=null?objects[2].toString():null);
			cf.setValor(objects[3]!=null?Double.parseDouble(objects[3].toString()):null);
			cfList.add(cf);
		}
		return cfList;
	}
	
	
	/**
	 * metodo que reetorna un json
	 * @return la lista de objetos especiales
	 */
	@RequestMapping(value="/api/articulos/search/especiales")
	public List<ClienteArticuloEspecial> darClientesEspeciales()
	{
		Query query = em.createQuery("select e.codigo, c.razsoc, e.articulo, e.referencia, e.precio"
				+ "					  from Articulo a, Especia e, Clientes c"
				+ "					  where a.codigo = e.articulo and e.codigo = c.codigo"
				+ "                   order by e.codigo, e.articulo");
		@SuppressWarnings("unchecked")
		List<Object[]> resultado = query.getResultList();
		List<ClienteArticuloEspecial> retorno = new ArrayList<>();
		for (Object[] fila : resultado) 
		{
			ClienteArticuloEspecial cas = new ClienteArticuloEspecial();
			cas.setArticulo((Long) ((fila[2] != null)? fila[2]: null));
			cas.setCodigo((Long) ((fila[0] != null)? fila[0]: null));
			cas.setPrecio((Double) ((fila[4] != null)? fila[4]: null));
			cas.setRazonSocial((String)  ((fila[1] != null)? fila[1]: null));
			cas.setReferencia((String)((fila[3] != null)? fila[3]: null));
			retorno.add(cas);
		}
		return retorno;
	}
	
	/**
	 * funcíon que retorna los artoculos paginados
	 * @param pagina
	 * @return
	 */
	@RequestMapping(value="/api/articulos/")
	public Page<Articulo> todosLosArticulos(@RequestParam(defaultValue="0") Integer pagina){
		Page<Articulo> pages = articuloRepository.findAll(new PageRequest(pagina, 30));
		return pages;
	}
	
	@RequestMapping(value="/api/articulos/search/articulosgeneros")
	public List<ArticuloGenero> darArticulosGenero(){
		List<Object[]> resultado = articuloRepository.darArticulosGenero();
		ArrayList<ArticuloGenero> articulos = new ArrayList<>();
		for (Object[] articulo : resultado) 
		{
			ArticuloGenero nuevo = new ArticuloGenero();
			nuevo.setNombre(articulo[0] != null?   (String)articulo[0].toString(): null);
			nuevo.setReferencia(articulo[1] != null? (String)articulo[1].toString() : null);
			nuevo.setPrecio(articulo[2] != null?  (Double)	articulo[2]: null);
			nuevo.setCodigo(articulo[3] != null ?(long)Double.parseDouble(articulo[3].toString()): null);
			articulos.add(nuevo);
		}
		return articulos;
	}
	
	/**
	 * función que retorna una lista de proveedores
	 * @return lista de proveedores
	 */
	@RequestMapping(value="/api/proveedores/")
	@SuppressWarnings("unchecked")
	public List<Proveedor> darProveedores(){
		Query q = em.createQuery("select new resultclasses.Proveedor( count(a) as numReg, procedenc ) from Articulo a group by a.procedenc");
		return q.getResultList();
	}
	
	/**
	 * 
	 */
	@RequestMapping(value="/api/articulos/{id}/especial", method = RequestMethod.GET,produces="application/json")
	public Articulo darArticuloEspecial(@PathVariable Long id, @RequestParam Long idCliente){
			Especia	especia = especiaRepository.findOneByCodigoAndArticulo( idCliente , id );
			Articulo actual = articuloRepository.findOne( id );
			if(especia != null){
				actual.setReferencia( especia.getReferencia( ) );
				actual.setPrecio( especia.getPrecio( ) );
			}
			return actual;
	}
	
	@RequestMapping( value = "/api/articulos/generocosto/{codigo}/")
	public ResponseEntity< ArticuloGeneroCostoDTO > darCostoConGenero( @PathVariable Long codigo ){
		
		ArticuloGeneroCostoDTO res = articuloService
				.darArticuloConGeneroCosto( codigo );
		
		if( res != null ){
			return new ResponseEntity<ArticuloGeneroCostoDTO>( res , HttpStatus.ACCEPTED );
		}
		return new ResponseEntity<ArticuloGeneroCostoDTO>( HttpStatus.BAD_REQUEST );
	}
}
