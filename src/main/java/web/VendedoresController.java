package web;
	
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String actualizaModeloVendedor(){
		return "vendedores/modelovendedor";
	}
}
