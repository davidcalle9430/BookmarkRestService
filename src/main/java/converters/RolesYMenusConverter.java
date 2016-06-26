package converters;

import org.springframework.core.convert.converter.Converter;

import sidic.entities.RolesymenusPK;

public class RolesYMenusConverter implements Converter<String, RolesymenusPK>{

	@Override
	public RolesymenusPK convert(String arg0) {
		// rol_codMenu
		String[] parametros = arg0.split("_");
		if( parametros.length == 2 ){
			return new RolesymenusPK(1, Long.parseLong(parametros[0]), parametros[1]);
		}
		return null;
	}

}
