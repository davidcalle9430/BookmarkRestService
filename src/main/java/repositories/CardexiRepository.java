package repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import sidic.entities.Cardexi;
@RepositoryRestResource
( path="/cardexi" , itemResourceRel = "cardexi", collectionResourceRel ="cardexi")

public interface CardexiRepository extends JpaRepository<Cardexi, Integer> 
{ 
	@RestResource
	public List<Cardexi> findOneByNdocAndFecha(
			@Param("ndoc")Long ndoc ,
			@DateTimeFormat(pattern = "yyyy-MM-dd")@Param("fecha") Date fecha);
	
	@RestResource
	public List<Cardexi> findAllByndocAndFecha(
			@Param("ndoc")Long ndoc,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("fecha") Date fecha);
}
