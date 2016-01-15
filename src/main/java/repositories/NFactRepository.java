package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Nfact;

@RepositoryRestResource( path="/nfact" , itemResourceRel = "nfact", collectionResourceRel ="nfacts") 
public interface NFactRepository extends JpaRepository<Nfact, Integer>{
	
}
