package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Niveles;
import sidic.entities.NivelesPK;
@RepositoryRestResource( path="/niveles" , itemResourceRel = "nivel", collectionResourceRel ="niveles")
public interface NivelesRepository extends JpaRepository<Niveles,NivelesPK>{
	
}
