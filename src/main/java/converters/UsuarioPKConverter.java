package converters;



import org.springframework.core.convert.converter.Converter;


import sidic.entities.UsuariosPK;
/**
 * Clase encargada de convertir una pk compuesta de String a Pk de usuario
 * @author david
 *
 */
public class UsuarioPKConverter implements Converter<String, UsuariosPK>{

	public UsuariosPK convert(String id){
		UsuariosPK retorno = new UsuariosPK(1, id);		
		return retorno;
	}
}
