package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComprasController 
{
	@RequestMapping(value="/mnucomi/")
	public String agregarCompraImp(){
		return "compras/agregarCompra";
	}
	
	@RequestMapping(value="/mnucomjm/")
	public String agregarCompraJm(){
		return "compras/agregarCompra";
	}
	
	@RequestMapping(value="/mnuconspedidos/")
	public String consultarPedidos(){
		return "compras/consultarPedidos";
	}
	
	@RequestMapping(value="/mnuconspedidos/listar/")
	public String consultarPedidosPorNdoc(){
		return "compras/listarPedidos";
	}
	
	@RequestMapping( value= "/Calcosjm/")
	public String calcularCostoJM(){
		return "compras/calcularcostojm";
	}
	
}

