package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.TextosFacturas;

@RepositoryRestResource( path="/textosFactura" , itemResourceRel = "textoFactura", collectionResourceRel ="textosFactura") 
public interface TextosFacturaRepository extends JpaRepository<TextosFacturas, Long>{
	
}
