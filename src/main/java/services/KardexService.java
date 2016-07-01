package services;

import java.util.Date;
import java.util.List;

import sidic.entities.Cardexi;

public interface KardexService {
	
	List< Cardexi > cardexArticuloImpordisa( Long codigo , Date fecha );
}
