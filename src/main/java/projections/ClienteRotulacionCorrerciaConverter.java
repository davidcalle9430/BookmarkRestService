package projections;

import org.springframework.data.rest.core.config.Projection;

import sidic.entities.Ciudades;
import sidic.entities.Clientes;
import sidic.entities.Correr;

@Projection(name="RotulacionCorreria", types = {Clientes.class})
public interface ClienteRotulacionCorrerciaConverter {
	Long getCodigo();
	String getRazsoc();
	String getRotulo();
	Ciudades getCiudad();
	Correr getCodcorr();
}
