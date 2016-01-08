package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Genero;
@RepositoryRestResource(path="/generos" , itemResourceRel = "genero", collectionResourceRel ="generos")
public interface GeneroRepository extends JpaRepository<Genero, Long>{

}
