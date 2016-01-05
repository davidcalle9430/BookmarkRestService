package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.Niveles;
import sidic.entities.NivelesPK;

public interface NivelesRepository extends JpaRepository<Niveles,NivelesPK>{

}
