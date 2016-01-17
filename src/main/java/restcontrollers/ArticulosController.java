package restcontrollers;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import resultclasses.ArticuloGenero;
import resultclasses.CardexFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import repositories.ArticuloRepository;
import sidic.entities.Articulo;;
@RestController
public class ArticulosController {
	@RequestMapping(value="/prueba/")
	public List<CardexFactura> test(@RequestParam("numerodoc")Long ndoc, @RequestParam("fecha")String fecha){
		System.out.println("si llego " + ndoc + fecha);
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
	@RequestMapping(value="/api/articulos/")
	public Page<Articulo> todosLosArticulos(@RequestParam(defaultValue="0") Integer pagina){
		Page<Articulo> pages = articuloRepository.findAll(new PageRequest(pagina, 30));
		return pages;
	}
	@RequestMapping(value="/api/articulos/search/articulosgeneros")
	public List<ArticuloGenero> darArticulosGenero(){
		List<Object[]> resultado = articuloRepository.darArticulosGenero();
		ArrayList<ArticuloGenero> articulos = new ArrayList<>();
		for (Object[] articulo : resultado) {
			ArticuloGenero nuevo = new ArticuloGenero();
			nuevo.setNombre(articulo[0] != null?   (String)articulo[0].toString(): null);
			nuevo.setReferencia(articulo[1] != null? (String)articulo[1].toString() : null);
			nuevo.setPrecio(articulo[2] != null?  (Double)	articulo[2]: null);
			nuevo.setCodigo(articulo[3] != null ?(long)Double.parseDouble(articulo[3].toString()): null);
			articulos.add(nuevo);
		}
		return articulos;
	}
	@Autowired
	private ArticuloRepository articuloRepository;
	@PersistenceContext
	private EntityManager em;
}
