package projections;

import org.springframework.data.rest.core.config.Projection;

import sidic.entities.Ciudades;
import sidic.entities.Clientes;

@Projection(name="rotulacion", types = {Clientes.class})
public interface ClienteRotulacion 
{
	Long getCodigo();
	String getRazsoc();
	String getRotulo();
	Ciudades getCiudad();
}