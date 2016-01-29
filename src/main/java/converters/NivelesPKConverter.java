package converters;

import org.springframework.core.convert.converter.Converter;

import sidic.entities.NivelesPK;
/**
 * Clase que convierte desde un string a una llave de primaria compuesta
 * @author david
 *
 */
public class NivelesPKConverter  implements Converter<String, NivelesPK> {

	@Override
	public NivelesPK convert(String nivel) {
		NivelesPK pk = new NivelesPK(1, Integer.parseInt(nivel));
		return pk;
	}

}
