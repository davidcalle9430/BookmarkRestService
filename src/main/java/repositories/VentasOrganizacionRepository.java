package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import sidic.entities.VentasseguimientoOrg;
import sidic.entities.VentasseguimientoOrgPK;
@RepositoryRestResource( path="/ventas" , itemResourceRel = "ventaorganizacion", collectionResourceRel ="ventasorganizacion")
public interface VentasOrganizacionRepository extends JpaRepository<VentasseguimientoOrg, VentasseguimientoOrgPK> {

}
