package repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import sidic.entities.Usuarios;
import sidic.entities.UsuariosPK;
@RepositoryRestResource( path="/users" , itemResourceRel = "users", collectionResourceRel ="users")
public interface UsuarioRepository extends JpaRepository<Usuarios, UsuariosPK>{
	@RestResource()
	public Usuarios findOneByUsuario(@Param("usuario") String usuario);
}
