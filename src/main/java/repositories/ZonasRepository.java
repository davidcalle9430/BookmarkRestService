package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Zonas;
@RepositoryRestResource( path="/zonas" , itemResourceRel = "zona", collectionResourceRel ="zonas")
public interface ZonasRepository extends JpaRepository<Zonas, String>{

}
