package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import sidic.entities.Ciudades;
@RepositoryRestResource( path="/ciudades" , itemResourceRel = "ciudad", collectionResourceRel ="ciudades")
public interface CiudadesRepository extends JpaRepository<Ciudades, Short>{
	@RestResource
	@Query("select max(c.codigo) + 1 AS codigo from Ciudades c")
	public Long darNuevoCodigo();
}
