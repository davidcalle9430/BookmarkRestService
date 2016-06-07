package converters;

import org.springframework.core.convert.converter.Converter;

import sidic.entities.EspeciaPK;

public class EspeciaConverter implements Converter<String, EspeciaPK> {

	@Override
	public EspeciaPK convert(String uri) {
		
		String[] arreglo = uri.split("--");
		long one = (long)Integer.parseInt(arreglo[0]);
		long two = (long)Integer.parseInt(arreglo[1]);
		EspeciaPK pk = new EspeciaPK( one , two );
		return pk;
	}
	

}
