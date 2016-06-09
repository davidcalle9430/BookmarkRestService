package repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import sidic.entities.Cartera;
import sidic.entities.CarteraPK;
@RepositoryRestResource( path="/carteras" , itemResourceRel = "cartera", collectionResourceRel ="carteras")
public interface CarteraRepository extends JpaRepository<Cartera, CarteraPK>{
	
	public List<Cartera> findByCarteraPK_Codigo(Long codigo);
	public List<Cartera> findByCarteraPK_Factura(Long factura);
	
	@RestResource(path="encontrarPorFacturaCodigoFecha", rel="encontrarPorFacturaCodigoFecha")
	public Cartera findOneByCarteraPK_facturaAndCarteraPK_CodigoAndCarteraPK_Fecha(@Param("factura")Long factura,@Param("codigo") Long codigo,@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("fecha")Date fecha);
	
}
