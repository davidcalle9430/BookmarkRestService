package services;

import org.springframework.beans.factory.annotation.Autowired;

import repositories.CostodeVentasRepository;
import resultclasses.CostoDeVentasIMDTO;

public class CostoDeVentasServiceImpl implements CostoDeVentasService {

	@Autowired
	private CostodeVentasRepository costoVRepository;
	
	
	@Override
	public boolean generar(CostoDeVentasIMDTO formulario) {
		costoVRepository.delete( costoVRepository.findAll() );
		return false;
	}

}
