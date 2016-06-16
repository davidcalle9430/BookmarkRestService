package restcontrollers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import sidic.entities.Cartera;
import sidic.entities.Nfact;
import sidic.entities.RecibosCaja;
import repositories.CarteraRepository;
import repositories.NFactRepository;
import repositories.RecibosCajaRepository;
import resultclasses.ArticuloFacturaDTO;
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
	
	@Autowired
	private NFactRepository nfactRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	
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
		recibo.setDescripcion( reciboCaja.getDescripcion() );
		recibo.setNd( 0.0 );
		recibo.setSaldo( 0.0 );
		recibo.setRetcree( 0.0 );
		recibo.setTiporecibo( Integer.parseInt( reciboCaja.getTipo() ) );
		recibo.setNombre( reciboCaja.getCodigo() +"-"+ reciboCaja.getRazsoc() );
		recibo.setConcepto( reciboCaja.getConcepto() );
		
		Nfact nfact = nfactRepository.findOne( 1 ); 
		nfact.setRecibocaja( nfact.getRecibocaja() + 1 );
		
		nfactRepository.save( nfact );
		reciboCajaRepository.save( recibo );
		
		return new ResponseEntity<>( HttpStatus.ACCEPTED );
	}
	
	@RequestMapping( value="/api/cartera/articulosFactura/", method = RequestMethod.GET )
	public List< ArticuloFacturaDTO > darArticulosFactura( 
			@RequestParam(name="ndoc") Long ndoc ,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name="fecha") Date fecha ){
		
		Query q = em.createQuery(
				 "select new "
				+ "resultclasses.ArticuloFacturaDTO( a.codigo , g.nombre , a.referencia , a.precio * c.cantidad )"
				+ "From Articulo a, Cardex c, Genero g "
				+ "Where a.codigo = c.codigo and a.codigo/1000 = g.codigo "
				+ "and c.ndoc = :ndoc "
				+ "and c.fecha = :fecha "
				+ "order by c.consec" 
				);
		q.setParameter( "ndoc", ndoc );
		q.setParameter( "fecha" , fecha );
		@SuppressWarnings("unchecked")
		List<ArticuloFacturaDTO> res
			= q.getResultList();
		return res;
	}
}
