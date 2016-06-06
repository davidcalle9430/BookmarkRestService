package projections;

import org.springframework.data.rest.core.config.Projection;

import sidic.entities.Clientes;
import sidic.entities.Especia;

@Projection(name="cliente", types = {Especia.class})
public interface EspeciaClienteConverter {
	Long getCodigo();
	Long getArticulo();
	String getReferencia();
	Double getPrecio();
	Clientes getClientes();
}
