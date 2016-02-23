package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import sidic.entities.Tipooperacion;

@RepositoryRestResource
( path="/tipoOperaciones" , itemResourceRel = "tipoOperacion", collectionResourceRel ="tipoOperaciones")

public interface TipoOperacionRepository extends JpaRepository<Tipooperacion, Short>
{
	@RestResource
	@Query("select max(t.codigo) from Tipooperacion t")
	public Short obtenerMaxTipoOperacion( );
}
