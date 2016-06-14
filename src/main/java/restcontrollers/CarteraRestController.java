package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import sidic.entities.Cartera;
import sidic.entities.RecibosCaja;
import repositories.CarteraRepository;
import repositories.RecibosCajaRepository;
import resultclasses.OtroReciboCajaDTO;

/**
 * Clase que se encarga de extender la funcionalidad de spring data 
 * rest en la entidad Cartera consiste en queries más complejas que 
 * necesitan de clases  resultado intermedias para poder ser retornadas como un JSON.
 *
 */

@RestController
public class CarteraRestController 
{
	@Autowired
	private CarteraRepository carteraRepository;
	
	@Autowired
	private RecibosCajaRepository reciboCajaRepository;
	
	
	@RequestMapping(value="/api/cartera/")
	public Page<Cartera> todosLosArticulos(@RequestParam(defaultValue="0") Integer pagina)
	{
		Page<Cartera> pag = carteraRepository.findAll(new PageRequest(pagina, 30));
		return pag;
	}
	
	@RequestMapping(value="/api/cartera/{codigo}/")
	public List<Cartera> darDetalleCartera(@PathVariable Long codigo)
	{
		return carteraRepository.findByCarteraPK_Codigo(codigo);
	}
	
	
	
	@RequestMapping(value="/api/cartera/reccartera/" , method = RequestMethod.POST , produces = "application/json" )
	public ResponseEntity<?> recCartera( @RequestBody Cartera cartera ){
		System.out.println("Entra a cambiar");
		Cartera aCambiar = carteraRepository.findOneByCarteraPK_CodigoAndCarteraPK_Factura( cartera.getCarteraPK().getCodigo() , cartera.getCarteraPK().getFactura() );
		aCambiar.setSaldo( cartera.getSaldo( ) );
		aCambiar.setNotad( cartera.getNotad( ) );
		aCambiar.setNotac( cartera.getNotac( ) );
		aCambiar.setObservac( cartera.getObservac( ) );
		try{
			carteraRepository.save( cartera );
			return new ResponseEntity<>( HttpStatus.ACCEPTED );
		}catch( Exception e ){
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
	}
	
	@RequestMapping( value="/api/cartera/otrosreciboscaja/")
	public ResponseEntity<?> otrosReciboCaja( @RequestBody OtroReciboCajaDTO reciboCaja  ){
		
		RecibosCaja recibo = new RecibosCaja();
		recibo.setNrorecibocaja( reciboCaja.getNumero( ) );
		recibo.setFecha( reciboCaja.getFecha() );
		
		if( reciboCaja.getCodigo() != null ){
			recibo.setCliente( Integer.parseInt( reciboCaja.getCodigo( ) ) );
		}else{
			recibo.setCliente( 0 );
		}
		recibo.setValorrecibo( Double.parseDouble( reciboCaja.getValor() ) );
		recibo.setNc( 0.0 );
		recibo.setPagadomas( 0.0 );
		recibo.setPagadomenos( 0.0 );
		recibo.setReteica( 0.0 );
		recibo.setReteiva( 0.0 );
		recibo.setRetefte( 0.0 );
		recibo.setTotal( Double.parseDouble( reciboCaja.getValor( ) ) );
		reciboCajaRepository.save( recibo );
		return new ResponseEntity<>( HttpStatus.ACCEPTED );
	}
	
	
}
