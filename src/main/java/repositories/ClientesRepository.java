package repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import sidic.entities.Clientes;
@RepositoryRestResource( path="/clientes" , itemResourceRel = "cliente", collectionResourceRel ="clientes")
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
	@RestResource()
	@Query("select max(c.codigo) from Clientes  c where c.codigo < ?1")
	public Integer encontrarSiguienteId(@Param("max")Long max);
	
	@RestResource()
	@Query("select max(c.codigo) from Clientes  c where c.codigo >= ?1")
	public Integer encontrarSiguienteIdOcasional(@Param("max")Long max);
	
	@RestResource()
	public Optional<List<Clientes>> findAllByCc(@Param("cc")String cc);
	
	@RestResource(path = "especiales", rel = "especiales")
	public List<Clientes> findAllByCamref(@Param("camref")String camref);
	
	@RestResource
	public Clientes findOneByCc( @Param("cc") String cc );
	
	@RestResource
	public Clientes findOneByNit( @Param("nit") String nit);

}
