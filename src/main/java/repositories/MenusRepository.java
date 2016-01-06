package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.Menus;
import sidic.entities.MenusPK;

public interface MenusRepository extends JpaRepository<Menus,MenusPK>{
	public Menus findOneByMenusPK_menu(String menu);
}
