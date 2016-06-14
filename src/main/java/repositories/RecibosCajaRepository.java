package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.RecibosCaja;


@RepositoryRestResource( path="/reciboscaja", 
	itemResourceRel = "recibocaja", 
	collectionResourceRel ="reciboscaja"
) 
public interface RecibosCajaRepository extends JpaRepository< RecibosCaja , Long > {

}
