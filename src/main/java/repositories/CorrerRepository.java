package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Correr;
@RepositoryRestResource( path="/corrers" , itemResourceRel = "correr", collectionResourceRel ="corrers")
public interface CorrerRepository extends JpaRepository<Correr, Long> {

}
