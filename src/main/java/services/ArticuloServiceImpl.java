package services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

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

}
