package services;

import resultclasses.ArticuloGeneroCostoDTO;

public interface ArticuloService {
	
	public Double darSumaDisponibleRango( Double inicio , Double fin );
	public Double darTotal();
	public ArticuloGeneroCostoDTO darArticuloConGeneroCosto( Long codigo );
	
}
