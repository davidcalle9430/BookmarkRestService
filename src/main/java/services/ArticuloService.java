package services;

import java.util.List;

import resultclasses.ArticuloGenero;
import resultclasses.ArticuloGeneroCostoDTO;
import resultclasses.CalcularCostoIMDTO;
import resultclasses.ClienteArticuloEspecial;
import resultclasses.InformacionArticuloDTO;


public interface ArticuloService {
	
	public Double darSumaDisponibleRango( Double inicio , Double fin );
	
	public Double darTotal( );
	
	public ArticuloGeneroCostoDTO darArticuloConGeneroCosto( Long codigo );
	
	public CalcularCostoIMDTO darCalcularCostoIMDTO (Long codigo);
	
	public List< ArticuloGenero > darArticulosGenero( Long codigoGenero );
	
	public List<ClienteArticuloEspecial> darClientesEspeciales();
	
	public InformacionArticuloDTO darInformacionArticulo( Long codigo );

	public Double darRotacion( Long codigo );
	
}
