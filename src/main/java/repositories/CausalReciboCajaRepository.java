package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Causalreciboscaja;

@RepositoryRestResource( path="/causalesrecibocaja" , itemResourceRel = "causalrecibocaja", collectionResourceRel ="causalesrecibocaja")
public interface CausalReciboCajaRepository extends JpaRepository< Causalreciboscaja, Integer > {

}
