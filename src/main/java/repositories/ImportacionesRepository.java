package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Importaciones;
import sidic.entities.ImportacionesPK;
@RepositoryRestResource( path="/importaciones" , itemResourceRel = "importacion", collectionResourceRel ="importaciones")
public interface ImportacionesRepository extends JpaRepository<Importaciones, ImportacionesPK>{

}
