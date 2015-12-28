package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.VentasseguimientoOrg;
import sidic.entities.VentasseguimientoOrgPK;

public interface VentasOrganizacionRepository extends JpaRepository<VentasseguimientoOrg, VentasseguimientoOrgPK> {

}
