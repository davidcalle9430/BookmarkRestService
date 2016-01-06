package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Rolesymenus;
import sidic.entities.RolesymenusPK;
@RepositoryRestResource( path="/rolesymenus" , itemResourceRel = "rolymenu", collectionResourceRel ="rolesymenus")
public interface RolesYMenusRepository extends JpaRepository<Rolesymenus,RolesymenusPK> {
	public List<Rolesymenus> findAllByUsuario(@Param("usuario")String usuario);
	public List<Rolesymenus> findAllByRolesymenusPK_Menu(String menu);
}
