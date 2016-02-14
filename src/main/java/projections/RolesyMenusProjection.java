package projections;

import org.springframework.data.rest.core.config.Projection;

import sidic.entities.Menus;
import sidic.entities.Rolesymenus;
import sidic.entities.RolesymenusPK;

@Projection(name="rolesymenus", types = {Rolesymenus.class})
public interface RolesyMenusProjection {
	Menus getMenus();
	RolesymenusPK getRolesymenusPK();
	
}
