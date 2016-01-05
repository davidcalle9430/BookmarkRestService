package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Articulo;
@RepositoryRestResource( path="/articulos" , itemResourceRel = "articulo", collectionResourceRel ="articulos") 
public interface ArticuloRepository extends JpaRepository<Articulo, Long>{

}
