package br.com.fiap.repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.Consulta
;
import br.com.fiap.model.StatusConsulta;

@Repository 
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByStatusConsultaAndDataConsultaBetween(
        StatusConsulta status, 
        LocalDateTime start, 
        LocalDateTime end);
    
    List<Consulta> findByPacienteIdAndStatusConsultaAndDataConsultaBetween(
        Long pacienteId, 
        StatusConsulta status, 
        LocalDateTime start, 
        LocalDateTime end);
    
    Long countByProfissionalId(Long profissionalId);
    
    BigDecimal sumValorConsultaByProfissionalId(Long profissionalId);
}