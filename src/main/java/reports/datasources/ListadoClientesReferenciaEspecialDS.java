package reports.datasources;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import resultclasses.ClienteArticuloEspecial;

public class ListadoClientesReferenciaEspecialDS implements JRDataSource {

	private final static String CODIGO_NOMBRE = "CodigoNombre";
	private final static String REFERNCIA = "Referencia";
	private final static String PRECIO = "Precio";
	
	private List< ClienteArticuloEspecial > clientes = new ArrayList<>();
	int indiceActual = -1;
	
	public ListadoClientesReferenciaEspecialDS( List<ClienteArticuloEspecial> clientes ) {
		this.clientes = clientes;
	}
	
	@Override
	public Object getFieldValue(JRField campo) throws JRException {
		
		Object retorno = null;
		String nombreCampo = campo.getName();
		
		if( PRECIO.equals( nombreCampo) ){ // la constante se pone primero en la comparacion para evitar null pointer exceptions
			retorno = clientes.get( indiceActual ).getPrecio();
		}else if( CODIGO_NOMBRE.equals( nombreCampo )){
			retorno = clientes.get( indiceActual ).getCodigo() + " " + clientes.get( indiceActual ).getRazonSocial();
		}else if( REFERNCIA.equals( nombreCampo )  ){
			retorno = clientes.get( indiceActual ).getReferencia();
		}
		return retorno;
	}

	@Override
	public boolean next() throws JRException {
		indiceActual++;
		if( indiceActual  < clientes.size() ){
			return true;
		}
		return false;
	}

}
