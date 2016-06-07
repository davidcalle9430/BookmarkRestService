package restcontrollers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import repositories.ClientesRepository;
import repositories.CorrerRepository;
import repositories.EspeciaRepository;
import sidic.entities.Clientes;
import sidic.entities.Correr;
import sidic.entities.Especia;
import sidic.entities.EspeciaPK;


@RestController
public class ClientesRestController {

	@Autowired
	private EspeciaRepository especiaRepo;
	
	@Autowired
	private CorrerRepository correrRepository;
	
	@Autowired
	private ClientesRepository clienteRepository;
	
	/**
	 * funcion que se encarga de cambiar el precio de una especial
	 * @param cliente
	 * @return
	 */
	@RequestMapping( value = "/api/especial", method = RequestMethod.PUT , produces="application/json" )
	public ResponseEntity<?> guardarCambioPrecio( @RequestBody Especia cliente){
		Especia especia = especiaRepo.findOne( new EspeciaPK( cliente.getCodigo() , cliente.getArticulo() ) );
		if( especia == null ){
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		especia.setPrecio( cliente.getPrecio() );
		especiaRepo.save( especia );
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	/**
	 * funcion que se encarga de acutalizar una lista de especiales
	 * @param especiales
	 * @return
	 */
	@RequestMapping( value = "/api/especial/lista", method = RequestMethod.POST , produces="application/json" )
	public ResponseEntity<?> actualizarEspecial( @RequestBody List<Especia> especiales ){
		for (Especia especia : especiales) {
			especiaRepo.save( especia );
		}
		return new ResponseEntity<>( HttpStatus.ACCEPTED );
	}
	
	@RequestMapping( value = "/api/clientes/actualizar/correria", method = RequestMethod.POST , produces="application/json" )
	public ResponseEntity<?> cambiarCorreria( @RequestBody Clientes cliente ){
		Correr correria = correrRepository.findOne( cliente.getCodcorr().getCodigo() );
		Clientes real = clienteRepository.findOne( cliente.getCodigo() );
		real.setCodcorr( correria );
		try{
			clienteRepository.save( real );
			return new ResponseEntity<>( HttpStatus.ACCEPTED );
		}catch( Exception e){
			e.printStackTrace();
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
	}
	
	
}
