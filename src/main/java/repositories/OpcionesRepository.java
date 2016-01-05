package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.Opciones;
import sidic.entities.OpcionesPK;

public interface OpcionesRepository extends JpaRepository<Opciones, OpcionesPK> {

}
