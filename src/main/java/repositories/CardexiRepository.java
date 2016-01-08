package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Cardexi;
@RepositoryRestResource( path="/cardexi" , itemResourceRel = "cardexi", collectionResourceRel ="cardexi")
public interface CardexiRepository extends JpaRepository<Cardexi, Integer> { }
