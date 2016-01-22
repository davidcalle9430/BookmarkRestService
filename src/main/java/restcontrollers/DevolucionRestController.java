package restcontrollers;


import java.util.List;

import resultclasses.Devolucion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import repositories.CardexiRepository;
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
	
	@Autowired CardexiRepository controCardex;
	@Autowired GeneroRepository controGenero;
	
	/**
	 * Método que se encarga de recorrer una lista de @Devolucion para actualizar 
	 * el objeto @Género asociado y agregar un nueo registro de una @Cardexi
	 * apoyándose en el controlador del api.
	 * @param compras: Lista de bodegas que contiene el @Genero y el @Cardexi a actualizar.
	 * @return Código de estado Http.
	 * **/
	@RequestMapping(value="/api/devolucion/", method = RequestMethod.PUT )
	public ResponseEntity<?> guardaDevolucion( @RequestBody List<Devolucion> devoluciones)
	{
		for (Devolucion devolucion : devoluciones ) 
		{
			controCardex.save( devolucion.getCardex( ) );
			controGenero.save( devolucion.getGenero( ) );
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
