package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import sidic.entities.Rolesymenus;
import sidic.entities.RolesymenusPK;

public interface RolesYMenusRepository extends JpaRepository<Rolesymenus,RolesymenusPK> {
	public List<Rolesymenus> findAllByUsuario(@Param("usuario")String usuario);
}
