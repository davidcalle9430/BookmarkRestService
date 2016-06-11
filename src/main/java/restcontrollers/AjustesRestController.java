package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import repositories.CarteraRepository;
import repositories.NFactRepository;
import resultclasses.NotaDCVentasDTO;
import resultclasses.NotasCarteraDTO;
import sidic.entities.Cartera;
import sidic.entities.Nfact;


/**
 * clase que expone los servicios web de las funcionalidades de ajustes
 * @author david
 *
 */
@RestController
public class AjustesRestController {
	
	@Autowired
	private CarteraRepository carteraRespository;
	
	@Autowired
	private NFactRepository nfactRepository;
	
	
	
	@RequestMapping(value="/api/ajustes/notasdecartera" , method = RequestMethod.POST )
	public ResponseEntity<?> notasDeCartera( @RequestBody List< NotasCarteraDTO > carteras ){

		for (NotasCarteraDTO cartera : carteras){
			if( cartera.getTipo().equalsIgnoreCase("J")){
				cartera.setFactura( cartera.getFactura() + 100000 );
			}else if( cartera.getTipo().equalsIgnoreCase("C")){	
				cartera.setFactura( cartera.getFactura() + 300000 );
			}
			Cartera carteraAGuardar = carteraRespository.findOneByCarteraPK_facturaAndCarteraPK_CodigoAndCarteraPK_Fecha( 
					(long)cartera.getFactura() , 
					(long)cartera.getCodigo() , 
					cartera.getFecha()  
			);
			
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
}
