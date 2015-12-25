package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
