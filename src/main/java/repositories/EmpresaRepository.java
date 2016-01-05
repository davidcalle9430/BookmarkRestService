package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sidic.entities.Empresas;

public interface EmpresaRepository extends JpaRepository<Empresas, Integer>{

}
