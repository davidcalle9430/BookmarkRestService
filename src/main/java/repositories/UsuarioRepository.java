package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.Usuarios;
import sidic.entities.UsuariosPK;

public interface UsuarioRepository extends JpaRepository<Usuarios, UsuariosPK>{
	public Optional<Usuarios> findOneByUsuario(String usuario);
}
