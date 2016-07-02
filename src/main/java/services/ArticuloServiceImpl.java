package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import repositories.ArticuloRepository;
import resultclasses.ArticuloGenero;
import resultclasses.ArticuloGeneroCostoDTO;
import resultclasses.CalcularCostoIMDTO;
import resultclasses.ClienteArticuloEspecial;
import resultclasses.InformacionArticuloDTO;
import sidic.entities.Articulo;
import utility.DateBuilder;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@PersistenceContext
	private EntityManager em;
	
	
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Double darSumaDisponibleRango( Double inicio , Double fin ) {
		
		Query q = em.createQuery(" "
				+ "select sum( a.cantdisp * a.costprom ) "
				+ "from Articulo a "
				+ "where a.cantdisp > 0 "
				+ "and  ( a.codigo / 1000 ) between :inicio and :fin ");;
		q.setParameter( "inicio" , (long)inicio.intValue());
		q.setParameter( "fin" , (long) fin.intValue() );
		Double res = (Double) q.getSingleResult(); 
		return  res;
	}


	@Override
	public Double darTotal() {
		Query q = em.createQuery(" "
				+ "select sum( a.cantdisp * a.costpromim ) "
				+ "from Articulo a ");
		Double res = (Double) q.getSingleResult(); 
		return  res;
	}


	@Override
	public ArticuloGeneroCostoDTO darArticuloConGeneroCosto( Long codigo ) {
		Query q = em.createQuery(" "
				+ "select new resultclasses.ArticuloGeneroCostoDTO( "
				+ "g.nombre , a.referencia , "
				+ "a.costprom , a.invimppas, "
				+ "a.ultcomp , a.ultcostpr , a.cosultcom ) "
				+ "from Articulo a , Genero g "
				+ "where FUNCTION( 'FLOOR' , a.codigo / 1000 ) = g.codigo "
				+ "and a.codigo = :codigo");
		q.setParameter( "codigo" , codigo );
		try{
			ArticuloGeneroCostoDTO res = ( ArticuloGeneroCostoDTO ) q.getSingleResult( );
			return res;
		}catch( Exception e ){
			return null;
		}
	}


	@Override
	public List<ArticuloGenero> darArticulosGenero(Long codigoGenero) {

		Query q = em.createQuery(" "
				+ "select new resultclasses.ArticuloGenero( "
				+ "a.codigo , g.nombre , "
				+ "a.referencia , a.precio ) "
				+ "from Articulo a , Genero g "
				+ "where FUNCTION( 'FLOOR' , a.codigo / 1000 ) = g.codigo "
				+ "and g.codigo = :codigo");
		q.setParameter( "codigo" , codigoGenero );
		try{
			@SuppressWarnings("unchecked")
			List< ArticuloGenero > res = q.getResultList();
			return res;
		}catch( Exception e ){
			e.printStackTrace();
			return null;
		}
	}

	public CalcularCostoIMDTO darCalcularCostoIMDTO(Long codigo) {
		
		Query q = em.createQuery(" "
				+ "select new resultclasses.CalcularCostoIMDTO( "
				+ "g.nombre , a.referencia , "
				+ "a.costprom , a.invimppas, "
				+ "a.ultcomp , a.ultcosproi ) "
				+ "from Articulo a , Genero g "
				+ "where FUNCTION( 'FLOOR' , a.codigo / 1000 ) = g.codigo "
				+ "and a.codigo = :codigo");
		q.setParameter( "codigo" , codigo );
		try{
			CalcularCostoIMDTO res = ( CalcularCostoIMDTO ) q.getSingleResult( );
			return res;
		}catch( Exception e ){
			return null;
		}
	}


	@Override
	public List<ClienteArticuloEspecial> darClientesEspeciales() {
		Query query = em.createQuery("select e.codigo, c.razsoc, e.articulo, e.referencia, e.precio"
				+ "					  from Articulo a, Especia e, Clientes c"
				+ "					  where a.codigo = e.articulo and e.codigo = c.codigo"
				+ "                   order by e.codigo, e.articulo");
		@SuppressWarnings("unchecked")
		List<Object[]> resultado = query.getResultList();
		List<ClienteArticuloEspecial> retorno = new ArrayList<>();
		for (Object[] fila : resultado) 
		{
			ClienteArticuloEspecial cas = new ClienteArticuloEspecial();
			cas.setArticulo((Long) ((fila[2] != null)? fila[2]: null));
			cas.setCodigo((Long) ((fila[0] != null)? fila[0]: null));
			cas.setPrecio((Double) ((fila[4] != null)? fila[4]: null));
			cas.setRazonSocial((String)  ((fila[1] != null)? fila[1]: null));
			cas.setReferencia((String)((fila[3] != null)? fila[3]: null));
			retorno.add(cas);
		}
		return retorno;
	}


	@Override
	public InformacionArticuloDTO darInformacionArticulo(Long codigo) {
		
		Query q = em.createQuery(" "
				+ "select new resultclasses.InformacionArticuloDTO( "
				+ "a.cantdisp, a.costprom , "
				+ "a.costpromim , a.codigo , "
				+ "a.precio , g.nombre , "
				+ "a.ultcosproi , a.referencia , a.uso , "
				+ "a.marca , a.procedenc , "
				+ "a.modelo1 , a.modelo2 , a.modelo3 ) "
				+ "from Articulo a , Genero g "
				+ "where FUNCTION( 'FLOOR' , a.codigo / 1000 ) = g.codigo "
				+ "and a.codigo = :codigo");
		
		q.setParameter( "codigo" , codigo );
		
		try {
			
		
			InformacionArticuloDTO res = (InformacionArticuloDTO) 
									q.getSingleResult();
			res.setRotacion( darRotacion( codigo ).intValue() );
			
			return res;
		}catch( Exception e ){
			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public Double darRotacion( Long codigo ) {
		
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		Double rotacion = 0.0; 
		
		Articulo a = articuloRepository.findOne( codigo );
		
		a.setInvimppas( a.getInvimppas( ) == null ? 0 : a.getInvimppas()  );
		a.setCantdisp( a.getCantdisp( ) == null ? 0 : a.getCantdisp() );

		boolean condicion = a.getFecsaldado() == null && a.getFecultimp() == null;
		boolean continuarCondicion = true;
		if( !condicion && a.getFecsaldado() == null 
				|| !condicion && a.getFecultimp() == null  ){
			continuarCondicion = false; // ya se sabe que son diferentes porque uno es nulo y el otro no
		}
		
		if( continuarCondicion ){
			if( a.getFecsaldado() != null && a.getFecultimp() != null ){
				condicion = a.getFecsaldado( ).equals( a.getFecultimp( ) );
			}
		}
		
		String fCorrecionNull;
		try{
			fCorrecionNull = DateBuilder.darFechaFormateada( a.getFecultimp() ) ;
		}catch( NullPointerException npe ){
			fCorrecionNull = null;
		}
		
		
		if( condicion 
				|| DateBuilder.darFechaFormateada( DateBuilder.crearFechaSinHora( )	 )
					.equals( fCorrecionNull )){
			
			String fechaString;
			try{
				fechaString = sdf.format( a.getFecultimp() );
			}catch( Exception e ){
				fechaString = "NULL";
			}
			
			Double res = 0.0;
			try{
				 res = // est variable solo define si existe o no, no srive para otra cosa, pero como no hay documentacion toca copiar tdo
						jdbc.queryForObject(  "select " // me mame de hacerlo terminos de entidades cuando el man chmabonea tanto!!!
									+ "if( cantidad = null , 0 , cantidad )"
									+ "from cardex "
									+ "where codigo =  " + codigo +
									  " and documento = 'PED' "
									+ "and " + fechaString  + " = " + "DATE_FORMAT( fecha ,'%Y-%m-%d')", Double.class );

			}catch( EmptyResultDataAccessException er ){
				res = 0.0;
			}
			
			if( res == 0.0 ){
				rotacion = 0.0; 
			}else{
				if( res > 0 ){
					rotacion = ( a.getInvimppas( ) - a.getCantdisp( ) ) * 30.0 / 
									(double)DateBuilder.getDifferenceDays( a.getFecultimp() , DateBuilder.crearFechaSinHora() ); 
				}else{
					rotacion = 0.0;
				}
			}
		}else{
			if( a.getCantdisp( ) == 0.0 ){
				if( a.getFecsaldado() == null ){
					rotacion = 0.0;
				}else{
					if( a.getFecultimp() != null && a.getFecsaldado() != null ){
						rotacion = a.getInvimppas() * 30.0 / (double) DateBuilder.getDifferenceDays( a.getFecultimp() , a.getFecsaldado() );
					}else{
						rotacion = 0.0;
					}
				}
			}else{
				if( a.getFecultimp() != null ){
					if( DateBuilder.getDifferenceDays( 
							a.getFecultimp() , DateBuilder.crearFechaSinHora() ) != 0 ){
						rotacion = ( a.getInvimppas()  - a.getCantdisp() ) * 30.0 
										/ (double) DateBuilder.getDifferenceDays( a.getFecultimp() , DateBuilder.crearFechaSinHora() );
					}else{
						rotacion = 0.0;
					}
				}else{
					rotacion = 0.0;
				}
			}
			
			if( a.getInvimppas() == 0.0 && rotacion < 0.0 ){
				rotacion = 0.0;
			}
			
		}
		return rotacion;
	}
	

}
