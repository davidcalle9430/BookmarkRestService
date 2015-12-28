package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.Importaciones;
import sidic.entities.ImportacionesPK;

public interface ImportacionesRepository extends JpaRepository<Importaciones, ImportacionesPK>{

}
