package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Ciudades;
@RepositoryRestResource( path="/ciudades" , itemResourceRel = "ciudad", collectionResourceRel ="ciudades")
public interface CiudadesRepository extends JpaRepository<Ciudades, Short>{

}
