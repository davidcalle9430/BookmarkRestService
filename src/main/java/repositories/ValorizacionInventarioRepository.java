package repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.ValorizacionInventario;
import sidic.entities.ValorizacionInventarioPK;

public interface ValorizacionInventarioRepository extends JpaRepository< ValorizacionInventario ,  ValorizacionInventarioPK > {

	public List< ValorizacionInventario > findAllByValorizacionInventarioPK_FechaAndValorizacionInventarioPK_LineaAndTiporeg(
				Date fecha,
				Long linea,
				Long tiporeg
	);
}
