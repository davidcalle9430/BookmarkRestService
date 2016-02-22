package projections;

import org.springframework.data.rest.core.config.Projection;

import sidic.entities.Ciudades;
import sidic.entities.Proveedores;

@Projection(name="ciudad", types = {Proveedores.class})
public interface ProveedorCiudad {
	Double getIdentificacion();
	String getNombre();
	String getDireccion();
	String getTelefono();
	String getUsuario();
	Ciudades getCiudad();
}
