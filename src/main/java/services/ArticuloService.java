package services;

import resultclasses.ArticuloGeneroCostoDTO;
import resultclasses.CalcularCostoIMDTO;


public interface ArticuloService {
	
	public Double darSumaDisponibleRango( Double inicio , Double fin );
	public Double darTotal();
	public ArticuloGeneroCostoDTO darArticuloConGeneroCosto( Long codigo );
	public CalcularCostoIMDTO darCalcularCostoIMDTO (Long codigo);
	
}
