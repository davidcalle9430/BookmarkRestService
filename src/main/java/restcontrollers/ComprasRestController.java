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

import resultclasses.AjustarCostoJMDTO;
import resultclasses.Compra;
import resultclasses.Pedido;
import sidic.entities.Articulo;
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
public class ComprasRestController {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired 
	private ArticuloRepository articuloRepository;
	
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
	public ResponseEntity<?> comprar( @RequestBody List<Compra> compras){
		for (Compra compra : compras) {
			Genero genero = controGenero.findOne( (long) Math.floor(compra.getArticulo().getCodigo()/1000 ));
			
			articuloRepository.save( compra.getArticulo( ) );
			controCardex.save( compra.getCardex( ) );
			
			if( genero != null ){
				if( genero.getCantdispjm() == null ){
					genero.setCantdispjm( compra.getArticulo( ).getUltcomp() );
				}
				else{
					genero.setCantdispjm( genero.getCantdispjm( ) + compra.getArticulo().getUltcomp( ) );
				}
				
				controGenero.save( genero );
			}
			
			if( compra.getImportacion() != null ){
				controImport.save(compra.getImportacion());
			}
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/api/obtenerPedidos/", method = RequestMethod.PUT )
	public List<Pedido> obtenerImportaciones( @RequestBody Map<String,String> params ){
		Query q;
		DateFormat formatter;

		Date fechaInicio = new Date();
		Date fechaFin = new Date();
		List<Pedido> pedidos;
		Double costo;
		Double venta;
		Double utilidad;
		
		if ( params.get("nDoc") != null ){
			q = em.createQuery("select new resultclasses.Pedido ( "
					+ "max(i.fecha) as fecha, "
					+ "i.ndoc,sum(i.costojm*i.cantidad) as costo, "
					+ "sum(i.precio*i.cantidad) as venta ) "
					+ "from Importaciones i where i.ndoc = :nDoc")
				.setParameter("nDoc", Double.parseDouble( params.get( "nDoc" ) ) );
		}
		else{
			formatter = new SimpleDateFormat("yyyy-MM-dd");

			try {
				fechaInicio = formatter.parse( params.get( "fechaInicio" ) );
				fechaFin = formatter.parse( params.get( "fechaFin" ) );
			} 
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			q = em.createQuery("select new resultclasses.Pedido "
					+ "( max(i.fecha) as fecha, i.ndoc, "
					+ "sum(i.costojm*i.cantidad) as costo, "
					+ "sum(i.precio*i.cantidad) as venta ) "
					+ "from Importaciones i "
					+ "where i.fecha between :fInicial and :fFinal "
					+ "group by i.ndoc")
					.setParameter("fInicial", fechaInicio, TemporalType.DATE )
					.setParameter("fFinal", fechaFin, TemporalType.DATE );
		}
		
		pedidos = q.getResultList();
		
		for (Pedido pedido : pedidos ) {
			costo = pedido.getCosto();
			venta = pedido.getVenta();
			utilidad = ( ( ( costo / venta ) - 1 ) * 100 ) * ( -1 );
			pedido.setUtilidad(utilidad);
		}
		
		return pedidos;
	}
	
	@RequestMapping( value ="/api/compras/ajustarcostojm/")
	public ResponseEntity<?> ajustarCostoJM( @RequestBody List<AjustarCostoJMDTO> articulos ){
		for (AjustarCostoJMDTO dto : articulos) {
			Articulo articulo = articuloRepository.findOne( dto.getCodigo() );
			articulo.setCostjm( dto.getNvocosto() );
			articulo.setCostprom( 
					( ( articulo.getInvimppas() - articulo.getUltcomp() ) * articulo.getUltcostpr() + dto.getNvocosto() ) / articulo.getInvimppas()   );
			articuloRepository.save( articulo );
		}
		return new ResponseEntity<>( HttpStatus.ACCEPTED );
	}
	
}
