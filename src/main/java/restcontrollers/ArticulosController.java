package restcontrollers;


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
	@Autowired
	private ArticuloRepository articuloRepository;
}
