package projections;

import org.springframework.data.rest.core.config.Projection;

import sidic.entities.Ciudades;
import sidic.entities.Clientes;
import sidic.entities.Correr;
import sidic.entities.Lineas;
import sidic.entities.Vendedor;

@Projection(name="factura", types = {Clientes.class})
public interface ClienteFactura 
{
	Long getCodigo();
	Correr getCodcorr();
	Lineas getLinea();
	Vendedor getVendedor();
	String getTelefono();
	String getRazsoc();
	String getDireccion();
	String getCamref();
	String getCc();
	Ciudades getCiudad();
	String getNit();
	String getProptario();
}
