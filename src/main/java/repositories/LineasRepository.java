package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Lineas;
@RepositoryRestResource( path="/lineas" , itemResourceRel = "linea", collectionResourceRel ="lineas")
public interface LineasRepository extends JpaRepository<Lineas, Long> {

}
