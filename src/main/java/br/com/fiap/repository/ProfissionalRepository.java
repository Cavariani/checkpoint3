package br.com.fiap.repository;

import br.com.fiap.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{
    
}
