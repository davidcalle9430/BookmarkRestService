package converters;

import org.springframework.core.convert.converter.Converter;

import sidic.entities.EspeciaPK;

public class EspeciaConverter implements Converter<String, EspeciaPK> {

	@Override
	public EspeciaPK convert(String uri) {
		String[] arreglo = uri.split("--");
		EspeciaPK pk = new EspeciaPK(Long.parseLong(arreglo[0]), Long.parseLong(arreglo[1]));
		return pk;
	}
	

}
