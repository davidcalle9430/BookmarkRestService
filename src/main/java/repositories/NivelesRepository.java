package repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import sidic.entities.Niveles;
import sidic.entities.NivelesPK;
@RepositoryRestResource( path="/niveles" , itemResourceRel = "nivel", collectionResourceRel ="niveles")
public interface NivelesRepository extends JpaRepository<Niveles,NivelesPK>{
	
	@RestResource()
	public Niveles findOneByNivelesPK_nivel(@Param("nivel") Integer nivel);
	@Transactional
	@Modifying
	@Query("update Niveles set descripcion=?2, fecha =?3 where nivel=?1")
	public int actualizarNivel(int nivel, String descripcion, Date fecha);
}
