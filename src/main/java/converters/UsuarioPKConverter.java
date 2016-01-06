package converters;



import org.springframework.core.convert.converter.Converter;


import sidic.entities.UsuariosPK;

public class UsuarioPKConverter implements Converter<String, UsuariosPK>{
	/*
	 * (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 * método se encarga de convertir la llave primaria de un objeto en un string
	 * es necesario que ningún usuario tenga el caracter especial _
	 * cuando no tiene el _ se asume que tiene la empresa 0
	 */
	public UsuariosPK convert(String id){
		UsuariosPK retorno = new UsuariosPK(1, id);		
		return retorno;
	}
}
