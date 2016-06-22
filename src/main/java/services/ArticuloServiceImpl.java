package services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import resultclasses.ArticuloGeneroCostoDTO;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@PersistenceContext
	private EntityManager em;
	
	
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
		System.out.println("se busca un codigo " + codigo );
		Query q = em.createQuery(" "
				+ "select new resultclasses.ArticuloGeneroCostoDTO( "
				+ "g.nombre , a.referencia , "
				+ "a.costprom , a.invimppas, "
				+ "a.ultcomp , a.ultcostpr ) "
				+ "from Articulo a , Genero g "
				+ "where FUNCTION( 'FLOOR' , a.codigo / 1000 ) = g.codigo "
				+ "and a.codigo = :codigo");
		q.setParameter( "codigo" , codigo );
		try{
			ArticuloGeneroCostoDTO res = ( ArticuloGeneroCostoDTO ) q.getSingleResult( );
			return res;
		}catch( Exception e ){
			e.printStackTrace();
			return null;
		}
	}

}
