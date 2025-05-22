package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
