package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InventarioController {
	

	
	@RequestMapping(value="/mnuajcandcjm/")
	public String ajustarCantidadesCodigo(){
		return "inventario/ajustarcantidadescodigo";
	}
	
	@RequestMapping(value="/mnuajupi/")
	public String ajustarPreciosCodigo(){
		return "inventario/ajustarPreciosCodigo";
	}
	
	
   @RequestMapping(value="/mnuajucsi/")
   public String ajustarCantidadSecuencial(){
	   return "inventario/ajustarCantidadSecuencial";
   }
   
   @RequestMapping(value="/mnuajucsi/editar/")
   public String ajustarCantidadSecuencialEditar(){
	   return "inventario/ajustarCantidadSecuencialEditar";
   }
   
   @RequestMapping(value="/mnuajupsi/")
   public String ajustarPreciosSecuencial( ){
	   
	   return "inventario/ajustarpreciossecuencial";
	   
   }
   
   @RequestMapping(value="/mnuactpjm/")
   public String actualizarPorcentajes( ){
	   
	   return "inventario/actualizarPorcentajes";  
   }
}

