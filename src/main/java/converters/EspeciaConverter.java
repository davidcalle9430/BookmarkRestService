package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.SocketUtils;

import sidic.entities.EspeciaPK;

public class EspeciaConverter implements Converter<String, EspeciaPK> {

	@Override
	public EspeciaPK convert(String uri) {
		
		String[] arreglo = uri.split("--");
		System.out.println("El string que lelga es  " + uri + " dividido por  " + arreglo[ 0 ]+ " y " + arreglo[ 1 ]);
		long one = (long)Integer.parseInt(arreglo[0]);
		long two = (long)Integer.parseInt(arreglo[1]);
		System.out.println("los num son " + one +" y "+ two);
		EspeciaPK pk = new EspeciaPK( one , two );
		return pk;
	}
	

}
