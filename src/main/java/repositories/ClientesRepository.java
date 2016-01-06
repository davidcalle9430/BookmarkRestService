package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Clientes;
@RepositoryRestResource( path="/clientes" , itemResourceRel = "cliente", collectionResourceRel ="clientes")
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
