package projections;

import org.springframework.data.rest.core.config.Projection;

import sidic.entities.Tipooperacion;
import sidic.entities.Tipooperacionbases;
import sidic.entities.TipooperacionbasesPK;

@Projection(name="tipo", types = {Tipooperacionbases.class})
public interface BasesTipoOperacion {
	
	TipooperacionbasesPK getTipooperacionbasesPK();
	
	Double getBase();
	
	Double getPorcentaje();
	
	String getTipo();
	
	Tipooperacion getTipooperacion1();
	
}
