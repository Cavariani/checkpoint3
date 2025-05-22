package br.com.fiap.service;

import br.com.fiap.dto.consulta.ConsultaRequestCreate;
import br.com.fiap.dto.consulta.ConsultaRequestUpdate;
import br.com.fiap.model.Consulta;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Profissional;
import br.com.fiap.model.StatusConsulta;
import br.com.fiap.repository.ConsultaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ProfissionalService profissionalService;

    @Autowired
    private PacienteService pacienteService;

    @Transactional
    public Consulta createConsulta(ConsultaRequestCreate dto) {
        Optional<Profissional> profissionalOpt = profissionalService.getProfissionalById(dto.getProfissionalId());
        Optional<Paciente> pacienteOpt = pacienteService.getPacienteById(dto.getPacienteId());

        if (profissionalOpt.isEmpty() || pacienteOpt.isEmpty()) {
            return null; // Ou lance uma exceção padrão se preferir
        }

        Profissional profissional = profissionalOpt.get();
        Paciente paciente = pacienteOpt.get();

        Consulta consulta = new Consulta();
        consulta.setProfissional(profissional);
        consulta.setPaciente(paciente);
        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setStatusConsulta(StatusConsulta.AGENDADA);
        consulta.setQuantidadeHoras(dto.getQuantidadeHoras());

        BigDecimal valorHora = new BigDecimal(profissional.getValor_hora());
        BigDecimal horas = new BigDecimal(dto.getQuantidadeHoras());
        consulta.setValorConsulta(valorHora.multiply(horas));

        return consultaRepository.save(consulta);
    }

    @Transactional(readOnly = true)
    public List<Consulta> filterConsultas(String status, LocalDate dataDe, LocalDate dataAte) {
        StatusConsulta statusEnum = status != null ? 
            StatusConsulta.valueOf(status.toUpperCase()) : null;

        LocalDateTime startDateTime = dataDe != null ? dataDe.atStartOfDay() : null;
        LocalDateTime endDateTime = dataAte != null ? dataAte.atTime(23, 59, 59) : null;

        return consultaRepository.findByStatusConsultaAndDataConsultaBetween(
            statusEnum, startDateTime, endDateTime);
    }

    @Transactional(readOnly = true)
    public Optional<Consulta> getConsultaById(Long id) {
        return consultaRepository.findById(id);
    }

    @Transactional
    public Optional<Consulta> updateConsulta(Long id, ConsultaRequestUpdate dto) {
        return consultaRepository.findById(id)
            .map(consulta -> {
                if (dto.getDataConsulta() != null) {
                    consulta.setDataConsulta(dto.getDataConsulta());
                }
                if (dto.getStatusConsulta() != null) {
                    consulta.setStatusConsulta(dto.getStatusConsulta());
                }
                if (dto.getQuantidadeHoras() != null) {
                    consulta.setQuantidadeHoras(dto.getQuantidadeHoras());
                    BigDecimal valorHora = new BigDecimal(consulta.getProfissional().getValor_hora());
                    BigDecimal horas = new BigDecimal(dto.getQuantidadeHoras());
                    consulta.setValorConsulta(valorHora.multiply(horas));
                }
                return consultaRepository.save(consulta);
            });
    }

    @Transactional
    public boolean deleteConsulta(Long id) {
        if (consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public List<Consulta> getConsultasPorPaciente(Long pacienteId, String status, LocalDate dataDe, LocalDate dataAte) {
        StatusConsulta statusEnum = status != null ? 
            StatusConsulta.valueOf(status.toUpperCase()) : null;

        LocalDateTime start = dataDe != null ? dataDe.atStartOfDay() : null;
        LocalDateTime end = dataAte != null ? dataAte.atTime(23, 59, 59) : null;

        return consultaRepository.findByPacienteIdAndStatusConsultaAndDataConsultaBetween(
            pacienteId, statusEnum, start, end);
    }

    @Transactional(readOnly = true)
    public Map<String, Object> getEstatisticasProfissional(Long profissionalId) {
        Long totalConsultas = consultaRepository.countByProfissionalId(profissionalId);
        BigDecimal valorTotal = consultaRepository.sumValorConsultaByProfissionalId(profissionalId);

        return Map.of(
            "total_consultas", totalConsultas != null ? totalConsultas : 0,
            "valor_total", valorTotal != null ? valorTotal : BigDecimal.ZERO
        );
    }
}
