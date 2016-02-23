package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Vendedor;

@RepositoryRestResource
( path="/vendedores" , itemResourceRel = "vendedor", collectionResourceRel ="vendedores")
public interface VendedorRepository extends JpaRepository<Vendedor, String> 
{

}
