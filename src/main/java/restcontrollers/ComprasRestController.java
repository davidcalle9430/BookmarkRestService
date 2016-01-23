package restcontrollers;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import resultclasses.Compra;
import sidic.entities.Genero;
import sidic.entities.Importaciones;

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
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired 
	private ArticuloRepository controArticulo;
	
	@Autowired 
	private CardexRepository controCardex;
	
	@Autowired 
	private ImportacionesRepository controImport;
	
	@Autowired 
	private GeneroRepository controGenero;
	
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/api/obtenerImportaciones/", method = RequestMethod.PUT )
	public List<Importaciones> obtenerImportaciones( @RequestBody Map<String,String> params )
	{
		Query q;
		System.out.println("NDOC: " + params.get("nDoc"));
		if ( params.get("nDoc") != null )
		{
			q = em.createQuery("select i from Importaciones i where i.ndoc = :nDoc").setParameter("nDoc", Double.parseDouble( params.get( "nDoc" ) ) );
			System.out.println("ENTRO NDOC");
		}
		else
		{
			DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date fechaInicio = new Date();
			Date fechaFin = new Date();
			try {
				fechaInicio = formatter.parse( params.get( "fechaFin" ) );
				fechaFin = formatter.parse( params.get( "fechaInicio" ) );
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			q = em.createQuery("select i from Importaciones i where i.fecha between :fInicial and :fFinal")
					.setParameter("fInicial", fechaInicio, TemporalType.DATE )
					.setParameter("fFinal", fechaFin, TemporalType.DATE );
			System.out.println("ENTRO FECHA");
		}

		 return q.getResultList();
	}
}
