package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, String> {

}
