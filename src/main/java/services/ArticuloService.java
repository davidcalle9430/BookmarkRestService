package services;

import java.util.List;

import resultclasses.ArticuloGenero;
import resultclasses.ArticuloGeneroCostoDTO;

public interface ArticuloService {
	
	public Double darSumaDisponibleRango( Double inicio , Double fin );
	
	public Double darTotal();
	
	public ArticuloGeneroCostoDTO darArticuloConGeneroCosto( Long codigo );
	
	public List< ArticuloGenero > darArticulosGenero( Long codigoGenero );
	
}
