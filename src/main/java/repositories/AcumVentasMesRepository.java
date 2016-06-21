package repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.AcumVentasMes;

public interface AcumVentasMesRepository extends JpaRepository< AcumVentasMes , Date >{
	
	
}
