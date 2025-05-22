package br.com.fiap.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.dto.paciente.PacienteRequestCreate;
import br.com.fiap.dto.paciente.PacienteRequestUpdate;
import br.com.fiap.model.Paciente;

@Service
public class PacienteService {

    private List<Paciente> pacientes = new ArrayList<>();
    private Long sequence = 1L;

    public Paciente createPaciente(PacienteRequestCreate dto) {
        Paciente paciente = new Paciente();
        paciente.setId(sequence++);
        paciente.setNome(dto.getNome());
        paciente.setEndereco(dto.getEndereco());
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefone_completo(dto.getTelefone_completo());
        paciente.setCreated_at(LocalDateTime.now());
        paciente.setUpdated_at(LocalDateTime.now());
        pacientes.add(paciente);
        return paciente;
    }

    public Optional<Paciente> getPacienteById(Long id) {
        return pacientes.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
    }
    
    public List<Paciente> getAll() {
        return pacientes;
    }

    public Optional<Paciente> updatePaciente(Long id, PacienteRequestUpdate dto) {
        return pacientes.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .map(p -> {
                if(dto.getNome() != null) p.setNome(dto.getNome());
                if(dto.getEndereco() != null) p.setEndereco(dto.getEndereco());
                if(dto.getBairro() != null) p.setBairro(dto.getBairro());
                if(dto.getEmail() != null) p.setEmail(dto.getEmail());
                if(dto.getTelefone_completo() != null) p.setTelefone_completo(dto.getTelefone_completo());
                p.setUpdated_at(LocalDateTime.now());
                return p;
            });
    }

    public boolean deletePaciente(Long id) {
        return pacientes.removeIf(p -> p.getId().equals(id));
    }
}