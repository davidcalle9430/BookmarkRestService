package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Rolessss;
import sidic.entities.RolessssPK;
@RepositoryRestResource( path="/roles" , itemResourceRel = "rol", collectionResourceRel ="roles")
public interface RolesRepository extends JpaRepository<Rolessss, RolessssPK> {
	public Rolessss findOneByRolessssPK_codigo(Long codigo);
}
