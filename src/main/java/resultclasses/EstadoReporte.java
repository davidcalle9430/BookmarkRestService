package resultclasses;

/**
 * clase encargada de represnetar el estado de generación de un reporte
 * @author david
 *
 */
public class EstadoReporte {
	
	
	// JAMAS cambiar el valro de las constantes porque afectan directamente el JS
	
	public final static String NINGUNO = "ninguno";
	public final static String GENERANDO = "generando";
	public final static String TERMINADO = "terminado";

	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public EstadoReporte(String estado) {
		super();
		this.estado = estado;
	}
	
	
	
}
