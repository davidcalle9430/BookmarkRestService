package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.Cartera;
import sidic.entities.CarteraPK;

public interface CarteraRepository extends JpaRepository<Cartera, CarteraPK>{
	
	public List<Cartera> findByCarteraPK_Codigo(Long codigo);
	public List<Cartera> findByCarteraPK_Factura(Long factura);
}
