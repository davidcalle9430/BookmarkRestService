package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Causales;

@RepositoryRestResource( path="/causales" , itemResourceRel = "causal", collectionResourceRel ="causales")
public interface CausalesRepository extends JpaRepository< Causales , Integer > {

}
