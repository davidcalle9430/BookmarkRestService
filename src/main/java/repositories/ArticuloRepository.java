package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import sidic.entities.Articulo;
@RepositoryRestResource( path="/articulos" , itemResourceRel = "articulo", collectionResourceRel ="articulos") 
public interface ArticuloRepository extends JpaRepository<Articulo, Long>{
		
	@RestResource
	@Query("select max(codigo) from Articulo a where a.codigo >= ?1 and a.codigo < ?2")
	public Long darSiguienteCodigoCategoria(@Param("min")Long min,@Param("max") Long max);
	
	@Query( nativeQuery = true , value = "SELECT g.nombre, a.referencia, a.precio, a.codigo "
			+ "FROM articulo a "
			+ "JOIN genero g on LEFT( LPAD( a.codigo , 6 , '0' ) , 3) = LPAD( g.codigo , 3 ,'0' )")
	List<Object[]> darArticulosGenero();
	
	@RestResource
	public Articulo findOneBycodigo(@Param("codigo")Long codigo);
	
	@Query("select a from Articulo a, Lineas l where ((a.codigo / 1000) between l.rango1 and l.rango2) and l.permiterefespecial='S'")
	@RestResource
	public List<Articulo> especialesLinea();
	
	@RestResource
	@Query("select a from Articulo a where a.cantdisp > 0")
	public List<Articulo> darConExistencias();
	
}