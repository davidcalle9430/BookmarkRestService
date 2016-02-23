package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Proveedores;
@RepositoryRestResource( path="/proveedores" , itemResourceRel = "proveedor", collectionResourceRel ="proveedores") 
public interface ProveedoresRepository extends JpaRepository<Proveedores, Double> {
	
}
