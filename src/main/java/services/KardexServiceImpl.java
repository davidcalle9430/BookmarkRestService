package services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import sidic.entities.Cardexi;

@Service
public class KardexServiceImpl implements KardexService {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Cardexi> cardexArticuloImpordisa( Long codigo , Date fecha) {
		
		Query q = em.createQuery(
			  "select c "
			+ "from Cardexi c "
			+ "where c.codigo = :codigo "
			+ "and c.fecha >= :fecha "
			+ "order by c.codigo , c.fecha, c.consec "
		);
		q.setParameter( "codigo" , codigo );
		q.setParameter( "fecha" , fecha );
		@SuppressWarnings("unchecked")
		List< Cardexi > res = q.getResultList();
		
		return res;
	}

}
