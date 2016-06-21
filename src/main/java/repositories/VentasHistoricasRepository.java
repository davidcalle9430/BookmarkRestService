package repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Venthist;

@RepositoryRestResource( path="/ventashistoricas" , itemResourceRel = "ventahistorica", collectionResourceRel ="ventashistoricas") 
public interface VentasHistoricasRepository extends JpaRepository< Venthist , Integer >{
	
	public List<Venthist> findAllByFacturaAndFechaAndCliente( Long factura , Date fecha , Long cliente );
}
