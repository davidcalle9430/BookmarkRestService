package converters;



import org.springframework.core.convert.converter.*;
import sidic.entities.UsuariosPK;

public class UsuarioPKConverter implements Converter<String, UsuariosPK>{
	public UsuariosPK convert(String id){
		UsuariosPK retorno = new UsuariosPK(1, id); //Esto es necesario por la fachada de empresas que tiene
		return retorno;
	}
}
