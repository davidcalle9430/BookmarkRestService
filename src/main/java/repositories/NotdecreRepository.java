package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Notdecre;

@RepositoryRestResource( path="/notdecres" , itemResourceRel = "notdecre", collectionResourceRel ="notdecres")
public interface NotdecreRepository extends JpaRepository<Notdecre, Integer>{

}
