package restcontrollers;


import java.util.ArrayList;
import java.util.List;

import resultclasses.ArticuloGenero;

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
}
