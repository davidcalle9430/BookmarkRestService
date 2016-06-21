package restcontrollers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import sidic.entities.Articulo;
import sidic.entities.Cardex;
import sidic.entities.Cardexi;
import sidic.entities.Cartera;
import sidic.entities.CarteraPK;
import sidic.entities.Genero;
import sidic.entities.Nfact;
import sidic.entities.RecibosCaja;
import sidic.entities.Venthist;
import utility.DateBuilder;
import repositories.ArticuloRepository;
import repositories.CardexRepository;
import repositories.CardexiRepository;
import repositories.CarteraRepository;
import repositories.GeneroRepository;
import repositories.NFactRepository;
import repositories.RecibosCajaRepository;
import repositories.VentasHistoricasRepository;
import resultclasses.AnularFacturaDTO;
import resultclasses.ArticuloFacturaDTO;
import resultclasses.OtroReciboCajaDTO;
import services.CarteraService;
import services.PrincipalService;

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
	
	@Autowired
	private CardexRepository cardexRepository;
	
	
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private CardexiRepository cardexiRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CarteraService carteraService;
	
	@Autowired
	private PrincipalService principalService;
	
	@Autowired
	private VentasHistoricasRepository ventasHistoricasRepository;
	
	
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
	public ResponseEntity< List< ArticuloFacturaDTO >> darArticulosFactura( 
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
		
		if( resultados.size()  == 0 ){
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		
		List<ArticuloFacturaDTO> res= new ArrayList<>();
		
		for (Object[] objects : resultados) {
			ArticuloFacturaDTO cf = new ArticuloFacturaDTO();
			cf.setCodigo(objects[0]!=null?(long)Double.parseDouble(objects[0].toString()):null);
			cf.setNombre(objects[1]!=null? objects[1].toString(): null );
			cf.setReferencia( objects[2] != null ? objects[2].toString():null );
			cf.setValor(objects[3]!=null? Double.parseDouble(objects[3].toString()):null);
			res.add(cf);
		}
		return new ResponseEntity<>( res , HttpStatus.ACCEPTED );
	}
	
	@RequestMapping( value="/api/cartera/encontrarPorCodigoFechaFactura/", method = RequestMethod.GET , produces = "application/json" )
	public ResponseEntity<Cartera> encontrarPorCodigoFechaFactura(
			@Param("factura")Long factura ,
			@Param("codigo")Long codigo ,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("fecha") Date fecha) throws ParseException{
		CarteraPK carteraPk = new CarteraPK(
				codigo,
				fecha, 
				factura);
		Cartera respuesta =  carteraService.encontrarCartera( carteraPk );
		if( respuesta == null ){
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		return new ResponseEntity<Cartera>( respuesta , HttpStatus.ACCEPTED );
	}
	
	// se llama cuando jmq = false
	@RequestMapping( value="/api/factura/anular/", method = RequestMethod.POST , produces = "application/json" )
	public ResponseEntity<?> anularFactura( @DateTimeFormat(pattern = "yyyy-MM-dd") 
		@RequestBody AnularFacturaDTO anularDTO ) throws ParseException{
		
		System.out.println( anularDTO );
		
		CarteraPK cartera = new CarteraPK( 
				anularDTO.getCodigo(),
				new SimpleDateFormat("yyyy-MM-dd").parse(anularDTO.getFecha()),
				anularDTO.getFactura() );
		System.out.println( cartera );
		double Ac1 , Ac2;
		
		List<Cardex> cardexs = cardexRepository.findAllByndocAndFecha( 
						cartera.getFactura() , 
						cartera.getFecha() );
		
		for (Cardex cardex : cardexs) {
			//Actualiza cantidades en articulo
			Articulo articulo = articuloRepository.findOne( cardex.getCodigo() );
			articulo.setCantdisp( articulo.getCantdisp() + cardex.getCantidad() );
			articuloRepository.save( articulo );
			//Actualiza cantidades JM
			Genero genero = generoRepository.findOne( cardex.getCodigo()  / 1000 );
			if( genero != null ){
				genero.setCantdispjm( genero.getCantdispjm() + cardex.getCantidad() );
				generoRepository.save( genero );
			}
			//insertar un registro en cardex
			Date fechaActual = DateBuilder.crearFechaSinHora();
			Cardex nuevo = new Cardex();
			nuevo.setCodigo( cardex.getCodigo( ) );
			nuevo.setFecha( fechaActual );
			nuevo.setTipo("E");
			nuevo.setDocumento("ANU");
			nuevo.setCantidad( cardex.getCantidad() );
			nuevo.setNdoc( cardex.getNdoc() );
			nuevo.setSaldo( articulo!= null ? articulo.getCantdisp() : 0 );
			cardexRepository.save( nuevo );
			
		}
		//acutalizar impordisa
		List<Cardexi> cardexis =
				cardexiRepository.findAllByndocAndFecha( 
						cartera.getFactura() , 
						cartera.getFecha() );
		
		for (Cardexi cardexi : cardexis) {
			//Actualiza cantidades JM

			Genero genero = generoRepository.findOne( cardexi.getCodigo()  / 1000 );
			if( genero != null ){
				genero.setCantdisp( genero.getCantdisp() + cardexi.getCantidad() );
				generoRepository.save( genero );
			}
			Date fechaActual = DateBuilder.crearFechaSinHora();
			Cardexi nuevo = new Cardexi();
			nuevo.setCodigo( cardexi.getCodigo( ) );
			nuevo.setFecha( fechaActual );
			nuevo.setTipo("E");
			nuevo.setDocumento("ANU");
			nuevo.setCantidad( cardexi.getCantidad() );
			nuevo.setNdoc( cardexi.getNdoc() );
			nuevo.setSaldo( (long) (genero!= null ? genero.getCantdisp() : 0) );
			cardexiRepository.save( nuevo );
			
		}
		//modifica cartera
		Cartera carteraAEditar = carteraService.encontrarCartera( new CarteraPK( cartera.getCodigo() ,
				cartera.getFecha() ,
				cartera.getFactura() ) );

		if( carteraAEditar == null || carteraAEditar.getSubtot() == null ){
			System.out.println("No se econtro la cartera");
			Ac1 = 0;
		}else{
			Ac1 = carteraAEditar.getSubtot( );
			carteraRepository.delete( carteraAEditar );
		}
		//en el original hay un if de si no está en jmq, en este caso siempre es verdader
		//porque la funcionalidad del menú JM se quita
		//por si hay cuentas de cobro
		Long TmpFact = cartera.getFactura() + 300000;
		Cartera cuentaDeCobro = carteraService.encontrarCartera( new CarteraPK( 
				cartera.getCodigo( ), 
				cartera.getFecha( ),
				TmpFact ) );
		
		if( cuentaDeCobro == null  || cuentaDeCobro.getValor() == null ){
			Ac2 = 0;
		}else{
			Ac2 = cuentaDeCobro.getValor( );
			carteraRepository.delete( cuentaDeCobro );
		}
		
		//modificar el acumulado de ventas
		// verifica si la fecha de laf catura es del mes acutal, no tengo
		//ni la mas mínima idea de por que
		Date hoy = new Date();
		if( DateBuilder.getMonth( hoy ) ==  DateBuilder.getMonth( cartera.getFecha( ) ) ){
			//como no es jmq, se omite es pedazo
			Nfact nfact = nfactRepository.findOne( 1 );
			nfact.setAcumiva( nfact.getAcumiva() - Ac1 );
			nfact.setAcumsiniva( nfact.getAcumsiniva() - Ac2 );
			nfactRepository.save( nfact );
		}
		
		//llamado al servicio principal, equivalente a las funciones del pricipal.bas
		principalService.acumVentasMes();
		principalService.valorizacion();
		
		
		//borrar venta historica
		List<Venthist> historicas = ventasHistoricasRepository.findAllByFacturaAndFechaAndCliente( 
				cartera.getFactura(), 
				cartera.getFecha(), 
				cartera.getCodigo() );
		ventasHistoricasRepository.delete( historicas );
		//por si cuenta de cobro
		List<Venthist> cuentaCobro = ventasHistoricasRepository.findAllByFacturaAndFechaAndCliente( 
				cartera.getFactura() + 100000, 
				cartera.getFecha(), 
				cartera.getCodigo() );
		ventasHistoricasRepository.delete( cuentaCobro );
		//por si jm
		List<Venthist> jm = ventasHistoricasRepository.findAllByFacturaAndFechaAndCliente( 
				cartera.getFactura() + 300000, 
				cartera.getFecha(), 
				cartera.getCodigo() );
		ventasHistoricasRepository.delete( jm );
		return new ResponseEntity<>( HttpStatus.ACCEPTED );
	}

}
