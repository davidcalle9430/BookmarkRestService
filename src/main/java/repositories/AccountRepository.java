package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Usuario;
/**
* Reporitorio de cuentas
* interfaz encargada de crear en tiempo de compilación los métodos encargados
* de la persistencia en la base de datos
*
* @author  David Calle
* @version 1.0
* @since   2015-12-14
*/
public interface AccountRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByUsername(String username);
}
