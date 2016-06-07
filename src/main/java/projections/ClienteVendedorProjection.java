package projections;

import org.springframework.data.rest.core.config.Projection;

import sidic.entities.Ciudades;
import sidic.entities.Clientes;
import sidic.entities.Vendedor;

@Projection(name="ClienteVendedor", types = {Clientes.class})
public interface ClienteVendedorProjection {
	Long getCodigo();
	String getRazsoc();
	String getRotulo();
	Vendedor getVendedor();
	Ciudades getCiudad();
	String getActivo();
}
