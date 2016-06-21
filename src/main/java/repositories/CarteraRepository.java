package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.Cartera;
import sidic.entities.CarteraPK;


@RepositoryRestResource( path="/carteras" ,
	itemResourceRel = "cartera",
	collectionResourceRel ="carteras")
public interface CarteraRepository extends JpaRepository<Cartera, CarteraPK>{
	
	public List<Cartera> findByCarteraPK_Codigo(Long codigo);
	
	public List<Cartera> findByCarteraPK_Factura(Long factura);
	
	public Cartera findOneByCarteraPK_CodigoAndCarteraPK_Factura( Long codigo , Long factura );
	
}
