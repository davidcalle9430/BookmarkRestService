package web;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import repositories.ArticuloRepository;
import sidic.entities.Articulo;

/**
* Controlador de vendedor
* Clase encargada de crear, elminar, actualizar y eliminar usuarios
*
* @author  David Calle
* @author Fabián Merchán
* @author David Suárez
* @version 1.0
* @since   2015-01-29
*/
	
@Controller
public class VendedoresController {
	
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@RequestMapping(value = "/mnuvenjm/", method = RequestMethod.GET)
	public String vistaVendedores(){
		return "vendedores/vendedores";
	}
	
	@RequestMapping(value = "/mnuvenjm/editar", method = RequestMethod.GET)
	public String nuevoVendedor(){
		return "vendedores/vendedoresEditar";
	}
	
	/**
	 * actualiza referencia modelo vendedor
	 */
	@RequestMapping( value= "/mnuactrefermodel/" , method = RequestMethod.GET )
	public String actualizaModeloVendedor( Model model ){
		
		List< Articulo > articulos = articuloRepository.darConExistencias();
		model.addAttribute( "articulos" , articulos );
		
		return "vendedores/modelovendedor";
	}
	
	@RequestMapping( value= "/mnuactrefermodel/editar/" , method = RequestMethod.GET )
	public String actualizaModeloVendedorEditar(){
		return "vendedores/modelovendedoreditar";
	}
}
