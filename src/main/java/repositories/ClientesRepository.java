package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.hazelcast.core.Client;

import sidic.entities.Clientes;
@RepositoryRestResource( path="/clientes" , itemResourceRel = "cliente", collectionResourceRel ="clientes")
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
