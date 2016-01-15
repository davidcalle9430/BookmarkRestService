package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Plazos;
@RepositoryRestResource( path="/plazos" , itemResourceRel = "plazo", collectionResourceRel ="plazos") 
public interface PlazosRepository extends JpaRepository<Plazos, String>{
	
}
