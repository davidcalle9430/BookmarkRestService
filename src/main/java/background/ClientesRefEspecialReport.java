package background;

import java.util.concurrent.Future;

import resultclasses.EstadoReporte;

public interface ClientesRefEspecialReport {
	
	public EstadoReporte getEstado( );
	public Future<Boolean> generarReporte( String formato );
	
}
