package restcontrollers;


import java.util.List;

import resultclasses.DevolucionJM;
import sidic.entities.Genero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import repositories.ArticuloRepository;
import repositories.CardexRepository;
import repositories.GeneroRepository;

/**
 * Clase que se encarga de extender la funcionalidad de spring data rest en la entidad Devolucion
 * consiste en queries más complejas que necesitan de clases  resultado intermedias para poder ser retornadas como un JSON
 * @author David Suárez.
 *
 */

@RestController
public class DevolucionRestController 
{
	
	@Autowired 
	private CardexRepository controCardex;
	
	@Autowired 
	private GeneroRepository controGenero;
	
	@Autowired 
	private ArticuloRepository controArticulo;
	
	/**
	 * Método que se encarga de recorrer una lista de @Devolucion para actualizar 
	 * el objeto @Género asociado y agregar un nueo registro de una @Cardexi
	 * apoyándose en el controlador del api.
	 * @param compras: Lista de bodegas que contiene el @Genero y el @Cardexi a actualizar.
	 * @return Código de estado Http.
	 * **/
	@RequestMapping(value="/api/devolucionJM/", method = RequestMethod.PUT )
	public ResponseEntity<?> guardaDevolucionJM( @RequestBody List<DevolucionJM> devoluciones)
	{
		Genero genero;
		Double cantDispJm;
		
		for (DevolucionJM devolucion : devoluciones ) 
		{
			genero = controGenero.findOne( (long) Math.floor(devolucion.getArticulo( ).getCodigo()/1000 ));
			
			if( genero != null )
			{
				cantDispJm = genero.getCantdispjm();
				genero.setCantdispjm( cantDispJm + devolucion.getCardex( ).getCantidad( ) );
				controGenero.save( genero );
			}
		
			controCardex.save( devolucion.getCardex( ) );
			controArticulo.save( devolucion.getArticulo( ) );
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
