package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.Especia;
import sidic.entities.EspeciaPK;

public interface EspeciaRepository  extends JpaRepository<Especia, EspeciaPK>{

}
