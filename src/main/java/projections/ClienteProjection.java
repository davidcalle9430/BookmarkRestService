package projections;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import sidic.entities.Ciudades;
import sidic.entities.Clientes;
import sidic.entities.Correr;
import sidic.entities.Lineas;
import sidic.entities.Vendedor;
import sidic.entities.Zonas;

@Projection(name="edit", types = Clientes.class)
public interface ClienteProjection {
	 Long getCodigo();
	 String getRazsoc();
	 String getDireccion();
	 String getTelefono();
	 String getProptario();
	 String getGerente();
	 String getNit();
	 String getCc();
	 String getPedidos();
	 String getCobros();
	 String getCupo();
	 Date getFecha();
	 Date getFechaing();
	 String getRotulo();
	 String getCamref();
	 String getIca();
	 Double getPorcica();
	 String getActivo();
	 String getConsigna();
	 String getNombre1();
	 String getNombre2();
	 String getApellido1();
	 String getApellido2();
	 String getSucursales();
	 Double getNitN();
	 Integer getDigitovNit();
	 Integer getIdvendedor();
	 String getNuevo();
	 Date getFechamodif();
	 Ciudades getCiudad();
	 Correr getCodcorr();
	 Lineas getLinea();
	 Vendedor getVendedor();
	 Zonas getZona();
}
