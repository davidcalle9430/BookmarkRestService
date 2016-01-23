package repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import sidic.entities.Importaciones;
import sidic.entities.ImportacionesPK;

@RepositoryRestResource( path="/importaciones" , itemResourceRel = "importacion", collectionResourceRel ="importaciones")
public interface ImportacionesRepository extends JpaRepository<Importaciones, ImportacionesPK>
{
	@RestResource
	@Query("select i from Importaciones i group by i.ndoc order by i.ndoc")
	public List<Importaciones> obtenerImportaciones ( );
}
