package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import sidic.entities.Cartera;
import sidic.entities.CarteraPK;

@Service
public class CarteraServiceImpl implements CarteraService {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Cartera encontrarCartera( CarteraPK carteraPk ) {

		Date diaSiguiente = carteraPk.getFecha();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate localFecha = LocalDate.parse( DATE_FORMAT.format( carteraPk.getFecha() ) ); // esto se hace para sumarle un dia
		localFecha = localFecha.plusDays( 1l );
		try {
			diaSiguiente = DATE_FORMAT.parse( localFecha.toString() );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Query q = em.createQuery(""
				+ "select c "
				+ "from Cartera c "
				+ "where c.carteraPK.codigo = :codigo "
				+ "and c.carteraPK.factura = :factura "
				+ "and c.carteraPK.fecha between :inicio and :fin ");
		
		q.setParameter( "factura" , carteraPk.getFactura() );
		q.setParameter( "codigo" , carteraPk.getCodigo() );
		q.setParameter( "inicio" , carteraPk.getFecha() );
		q.setParameter( "fin" , diaSiguiente );

		Cartera cartera = (Cartera) q.getSingleResult( );
		return cartera;
	}

}
