package repositories;



import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import sidic.entities.Usuarios;
import sidic.entities.UsuariosPK;

@RepositoryRestResource( path="/users" , itemResourceRel = "users", collectionResourceRel ="users")
public interface UsuarioRepository extends JpaRepository<Usuarios, UsuariosPK>
{
	@RestResource()
	public Usuarios findOneByUsuario(@Param("usuario") String usuario);
	
	@Transactional
	@Modifying
	@Query("update Usuarios set password=?2, fechapassword =?3 where usuario=?1")
	public int actualizarContrasena(String Usuario, String contra, Date fecha);
}
