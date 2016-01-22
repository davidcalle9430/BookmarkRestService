package restcontrollers;


import java.util.List;


import resultclasses.Compra;
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
import repositories.ImportacionesRepository;
/**
 * Clase que se encarga de extender la funcionalidad de spring data rest en la entidad Compra
 * consiste en queries más complejas que necesitan de clases  resultado intermedias para poder ser retornadas como un JSON
 * @author David Suárez.
 *
 */
@RestController
public class ComprasRestController 
{
	
	@Autowired 
	ArticuloRepository controArticulo;
	@Autowired 
	CardexRepository controCardex;
	
	@Autowired 
	ImportacionesRepository controImport;
	
	@Autowired 
	GeneroRepository controGenero;
	
	/**
	 * Método que se encarga de recorrer una lista de @Compra para actualizar 
	 * el objeto @Género y @Articulo asociado y agregar un nueo registro 
	 * de una @Cardexi y @Importacion.
	 * apoyándose en el controaldor del api.
	 * @param compras: Lista de compras que contiene el @Genero y el @Cardexi a actualizar.
	 * @return Código de estado Http.
	 * **/
	@RequestMapping(value="/api/comprar/", method = RequestMethod.PUT )
	public ResponseEntity<?> comprar( @RequestBody List<Compra> compras)
	{
		for (Compra compra : compras) 
		{
			Genero genero = controGenero.findOne( (long) Math.floor(compra.getArticulo().getCodigo()/1000 ));
			
			if( genero.getCantdispjm() == null )
			{
				genero.setCantdispjm( compra.getArticulo( ).getUltcomp() );
			}
			else
			{
				genero.setCantdispjm( genero.getCantdispjm( ) + compra.getArticulo().getUltcomp( ) );
			}

			controArticulo.save( compra.getArticulo( ) );
			controCardex.save( compra.getCardex( ) );
			controGenero.save( genero );
			
			if( compra.getImportacion() != null )
			{
				controImport.save(compra.getImportacion());
			}
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
