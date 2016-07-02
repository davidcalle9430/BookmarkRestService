package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateBuilder {

	
	public static String darFechaFormateada( Date fecha ){
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		String res = DATE_FORMAT.format( fecha );
		return res;
	}
	
	public static Date crearFechaSinHora(){
		Date hoy = new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate localFecha = LocalDate.parse( DATE_FORMAT.format( hoy ) ); // esto se hace para sumarle un dia
		try {
			return DATE_FORMAT.parse( localFecha.toString() );
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int getMonth( Date fecha ){
		Calendar cal = Calendar.getInstance();
		cal.setTime( fecha );
		return cal.get( Calendar.MONTH );
	}
	
	public static int getDay( Date fecha ){
		Calendar cal = Calendar.getInstance();
		cal.setTime( fecha );
		return cal.get( Calendar.DAY_OF_MONTH );
	}
	
	public static String getNombreMes( Date fecha ){
		
		int month = getMonth( fecha );
		
		switch ( month ) {
		case 1:
			return "Enero";
		case 2:
			return "Febrero";
		case 3:
			return "Marzo";
		case 4:
			return "Abril";
		case 5:
			return "Mayo";
		case 6:
			return "Junio";
		case 7:
			return "Julio";
		case 8:
			return "Agosto";
		case 9:
			return "Septiembre";
		case 10:
			return "Octubre";
		case 11:
			return "Noviembre";
		case 12:
			return "Diciembre";
		}
		return "MES NO EXISTE";
	}
}
