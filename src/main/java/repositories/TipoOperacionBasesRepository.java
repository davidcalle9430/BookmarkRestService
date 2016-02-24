package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Tipooperacionbases;
import sidic.entities.TipooperacionbasesPK;

@RepositoryRestResource
( path="/tipoOperacionBases" , itemResourceRel = "tipoOperacionBase", collectionResourceRel ="tipoOperacionBases")
public interface TipoOperacionBasesRepository extends JpaRepository<Tipooperacionbases, TipooperacionbasesPK>
{

}
