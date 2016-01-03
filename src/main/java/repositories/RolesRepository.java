package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.Rolessss;
import sidic.entities.RolessssPK;

public interface RolesRepository extends JpaRepository<Rolessss, RolessssPK> {
	public Rolessss findOneByRolessssPK_codigo(Long codigo);
}
