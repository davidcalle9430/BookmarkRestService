package repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import sidic.entities.Cardex;

@RepositoryRestResource( path="/cardex" , itemResourceRel = "cardex", collectionResourceRel ="cardex")
public interface CardexRepository extends JpaRepository<Cardex,Integer>
{
	//@Query("select c from Cardex c where ndoc = ?0 and fecha = ?1")
	@RestResource
	public Cardex findOneByndocAndFecha(@Param("ndoc")Long ndoc,@DateTimeFormat(pattern = "yyyy-MM-dd")@Param("fecha") Date fecha);
}
