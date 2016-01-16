package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import sidic.entities.Especia;
import sidic.entities.EspeciaPK;

@RepositoryRestResource( path="/especia" , itemResourceRel = "especia", collectionResourceRel ="especias")
public interface EspeciaRepository  extends JpaRepository<Especia, EspeciaPK>{

	@RestResource
	public List<Especia> findByCodigo (@Param("codigo") Long codigo);
}
