package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.NfactLog;
@RepositoryRestResource( path="/nfactlog" , itemResourceRel = "nfactlog", collectionResourceRel ="nfactlogs") 
public interface NFactLogRepository extends JpaRepository<NfactLog, Integer> {

}
