package restcontrollers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import repositories.ArticuloRepository;
import repositories.CarteraRepository;
import repositories.NFactRepository;
import repositories.NotdecreRepository;
import resultclasses.CalcularCostoIMDTO;
import resultclasses.AjustarCostoJMDTO;
import resultclasses.NotaDCVentasDTO;
import resultclasses.NotasCarteraDTO;
import sidic.entities.Articulo;
import sidic.entities.Cartera;
import sidic.entities.Nfact;
import sidic.entities.Notdecre;
import services.ArticuloService;


/**
 * clase que expone los servicios web de las funcionalidades de ajustes
 * @author david
 *
 */
@RestController
public class AjustesRestController {


	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Autowired
	private CarteraRepository carteraRespository;
	
	@Autowired
	private NFactRepository nfactRepository;
	
	@Autowired
	private NotdecreRepository notdecreRepository;
	
	@Autowired
	private ArticuloService articuloService;
	
	@PersistenceContext
	private EntityManager em;
	
	@RequestMapping( value = "/api/ajustes/articulo/{codigo}/" , method = RequestMethod.GET )
	public ResponseEntity<CalcularCostoIMDTO> darCostoIM( @PathVariable Long codigo){
		CalcularCostoIMDTO calcIM = articuloService.darCalcularCostoIMDTO(codigo);
		if(calcIM == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);		
		}
		return new ResponseEntity<>(calcIM,HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping( value = "/api/ajustes/reporteventas/" , method = RequestMethod.POST )
	public ResponseEntity<?> reporteDeVentas( @RequestBody List< NotasCarteraDTO > carteras ){
	
		for (NotasCarteraDTO nota : carteras) {
			Notdecre notaCredito = new Notdecre();
			notaCredito.setFecha( new Date() );
			notaCredito.setCliente( (double)nota.getCodigo() );
			notaCredito.setFactura( (double) nota.getFactura() );
			if( nota.getNat().equalsIgnoreCase("D")){
				notaCredito.setValDeb( nota.getValor() );
				notaCredito.setValCre( 0.0 );
			}else{
				notaCredito.setValCre( nota.getValor() );
				notaCredito.setValDeb( 0.0 );
			}
			notaCredito.setIva( nota.getIva() );
			notaCredito.setCantidad( 0.0 );
			notaCredito.setCodigo( 0.0 );
			notaCredito.setPrecio( 0.0 );
			notaCredito.setDescue( 0.0 );
			notaCredito.setCausal( nota.getCausal() );
			notdecreRepository.save( notaCredito );
		}
		return new ResponseEntity<>( HttpStatus.ACCEPTED );
	}
	
	@RequestMapping(value="/api/ajustes/notasdecartera" , method = RequestMethod.POST )
	public ResponseEntity<?> notasDeCartera( @RequestBody List< NotasCarteraDTO > carteras ) throws ParseException{

		for (NotasCarteraDTO cartera : carteras){
			if( cartera.getTipo().equalsIgnoreCase("J")){
				cartera.setFactura( cartera.getFactura() + 100000 );
			}else if( cartera.getTipo().equalsIgnoreCase("C")){	
				cartera.setFactura( cartera.getFactura() + 300000 );
			}
			
			
			
			Date diaSiguiente = cartera.getFecha( );
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat( "yyyy-MM-dd" );
			LocalDate localFecha = LocalDate.parse( 
					DATE_FORMAT.format( cartera.getFecha( ) ) ); // esto se hace para sumarle un dia
			
			localFecha = localFecha.plusDays( 1l );
			diaSiguiente = DATE_FORMAT.parse( localFecha.toString() );
			
			//fin de creacion de fechas
			Query q = em.createQuery(""
					+ "select c "
					+ "from Cartera c "
					+ "where c.carteraPK.codigo = :codigo "
					+ "and c.carteraPK.factura = :factura "
					+ "and c.carteraPK.fecha between :inicio and :fin");
			q.setParameter( "factura" , cartera.getFactura() );
			q.setParameter( "codigo" , cartera.getCodigo() );
			q.setParameter( "inicio" , cartera.getFecha() );
			q.setParameter( "fin" , diaSiguiente );
			Cartera carteraAGuardar = (Cartera) q.getSingleResult( );
			
			if( cartera.getNat().equals("D") ){
				carteraAGuardar.setNotad( carteraAGuardar.getNotad() + cartera.getValor() );
			}else{
				carteraAGuardar.setNotac( carteraAGuardar.getNotac() + cartera.getValor() );
			}
			switch ( cartera.getCausal() ) {
				case 1:
					carteraAGuardar.setC1( carteraAGuardar.getC1() 
							+ cartera.getValor().intValue() 
							- cartera.getIva().intValue()  );
					break;
				case 2:
					carteraAGuardar.setC2( carteraAGuardar.getC2() 
							+ cartera.getValor().intValue() 
							- cartera.getIva().intValue()  );
					break;
				case 3:
					carteraAGuardar.setC3( carteraAGuardar.getC3() 
							+ cartera.getValor().intValue() 
							- cartera.getIva().intValue()  );
					break;
				case 4:
					carteraAGuardar.setC4( carteraAGuardar.getC4() 
							+ cartera.getValor().intValue() 
							- cartera.getIva().intValue()  );
					break;
				case 5:
					carteraAGuardar.setC5( carteraAGuardar.getC5() 
							+ cartera.getValor().intValue()  
							- cartera.getIva().intValue()  );
					break;
				case 6:
					carteraAGuardar.setC6( carteraAGuardar.getC6() 
							+ cartera.getValor().intValue()  
							- cartera.getIva().intValue()  );
					break;
			}
			carteraRespository.save( carteraAGuardar );
		}
		return new ResponseEntity<>( HttpStatus.ACCEPTED );
	}
	
	
	@RequestMapping( value = "/api/ajustes/notadebcredacumventas/")
	public ResponseEntity<?> notaDebCredAcumuladoVentas( @RequestBody List< NotaDCVentasDTO > notas ){
		Nfact nfact = nfactRepository.findOne( 1 );
		for (NotaDCVentasDTO nota : notas) {
			if( nota.getNat().equalsIgnoreCase( "C" ) ){
				if( nota.getTipo().equalsIgnoreCase( "I" ) ){
					nfact.setAcumiva( nfact.getAcumiva() - nota.getValor() );
				}else{
					nfact.setAcumsiniva( nfact.getAcumsiniva() - nota.getValor() );
				}
			}else{
				if( nota.getTipo().equalsIgnoreCase("I") ){
					nfact.setAcumiva( nfact.getAcumiva() + nota.getValor() );
				}else{
					nfact.setAcumsiniva( nfact.getAcumsiniva() + nota.getValor() );
				}
			}
		}
		nfactRepository.save( nfact );
		return new ResponseEntity<>( HttpStatus.ACCEPTED );
	}
	
	
	
	
	
	@RequestMapping( value = "/api/ajustes/corCostoImpordisa/" , method = RequestMethod.POST )
	public ResponseEntity<?> corCostoImpordisa( @RequestBody List< AjustarCostoJMDTO > articulos ){
		for (AjustarCostoJMDTO arti : articulos) {
			Articulo art = articuloRepository.findOne(arti.getCodigo());
			art.setCosultcom(arti.getNvocosto());
			if(art.getUltcosproi() == null){
				art.setUltcosproi(0.0);
			}

			Double resultado = ((art.getInvimppas()-art.getUltcomp())*art.getUltcosproi()+arti.getNvocosto()* art.getUltcomp())/art.getInvimppas();
			art.setCostpromim(resultado);
			articuloRepository.save(art);
			
		}
		
		return new ResponseEntity<>( HttpStatus.ACCEPTED );
	}
}
