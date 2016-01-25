package sidic.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="rotulacion", types = {Clientes.class})
public interface ClienteRotulacion {
	Long getCodigo();
	String getRazsoc();
	String getRotulo();
	Ciudades getCiudad();
}