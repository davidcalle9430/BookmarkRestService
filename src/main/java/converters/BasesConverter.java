package converters;

import org.springframework.core.convert.converter.Converter;

import sidic.entities.TipooperacionbasesPK;

public class BasesConverter implements Converter<String, TipooperacionbasesPK > {

	@Override
	public TipooperacionbasesPK convert(String ruta) {
		String[] split = ruta.split("--");
		if( split.length == 2 ){
			Short tipoOperacion = Short.parseShort(split[0]);
			TipooperacionbasesPK pk = new TipooperacionbasesPK(tipoOperacion, split[1]);
			return pk;
		}
		return null;
	}

}
