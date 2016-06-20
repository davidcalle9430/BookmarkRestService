package restcontrollers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
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
			@DateTimeFormat(pattern = "yyyy-MM-dd") 
				@RequestParam(name="fecha") Date fecha ){
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format( fecha );
		
		
		//toca native query porque por alguna razon no sirve jpql, ver commit anterior
		Query q = em.createNativeQuery(""
				+ "select  a.codigo , g.nombre , a.referencia , a.precio * c.cantidad AS precio "
				+ "From Articulo a, Cardex c, Genero g  "
				+ "Where a.codigo = c.codigo and  FLOOR( a.codigo / 1000 ) = g.codigo "
				+ "and c.ndoc =  :ndoc and c.fecha =  STR_TO_DATE( :fecha , '%Y-%m-%d') "
				+ "order by c.consec "
				);
		q.setParameter( "ndoc" , ndoc );
		q.setParameter( "fecha" , format );
		@SuppressWarnings("unchecked")
		List<Object[]> resultados  = q.getResultList();
		List<ArticuloFacturaDTO> res= new ArrayList<>();
		
		for (Object[] objects : resultados) {
			ArticuloFacturaDTO cf = new ArticuloFacturaDTO();
			cf.setCodigo(objects[0]!=null?(long)Double.parseDouble(objects[0].toString()):null);
			cf.setNombre(objects[1]!=null? objects[1].toString(): null );
			cf.setReferencia( objects[2] != null ? objects[2].toString():null );
			cf.setValor(objects[3]!=null? Double.parseDouble(objects[3].toString()):null);
			res.add(cf);
		}
		return res;
	}
	
	@RequestMapping( value="/api/cartera/encontrarPorCodigoFechaFactura/", method = RequestMethod.GET , produces = "application/json" )
	public Cartera encontrarPorCodigoFechaFactura(
			@Param("factura")Long factura ,
			@Param("codigo")Long codigo ,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("fecha") Date fecha) throws ParseException{
		
		// creacion de la siguente fecha, es decir un dia despues
		Date diaSiguiente = fecha;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate localFecha = LocalDate.parse( DATE_FORMAT.format( fecha ) ); // esto se hace para sumarle un dia
		localFecha = localFecha.plusDays( 1l );
		diaSiguiente = DATE_FORMAT.parse( localFecha.toString() );
		
		//fin de creacion de fechas
		Query q = em.createQuery(""
				+ "select c "
				+ "from Cartera c "
				+ "where c.carteraPK.codigo = :codigo "
				+ "and c.carteraPK.factura = :factura "
				+ "and c.carteraPK.fecha between :inicio and :fin");
		q.setParameter( "factura" , factura );
		q.setParameter( "codigo" , codigo );
		q.setParameter( "inicio" , fecha );
		q.setParameter( "fin" , diaSiguiente );
		Cartera c = (Cartera) q.getSingleResult( );
		return c;
	}
}
