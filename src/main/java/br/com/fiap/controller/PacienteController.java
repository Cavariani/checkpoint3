package br.com.fiap.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.paciente.PacienteRequestCreate;
import br.com.fiap.dto.paciente.PacienteRequestUpdate;
import br.com.fiap.dto.paciente.PacienteResponse;
import br.com.fiap.model.Paciente;
import br.com.fiap.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponse> create(
            @RequestBody PacienteRequestCreate dto) {
        Paciente paciente = pacienteService.createPaciente(dto);
        return ResponseEntity.status(201).body(new PacienteResponse().toDto(paciente));
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> getAll() {
        List<PacienteResponse> response = pacienteService.getAll().stream()
            .map(p -> new PacienteResponse().toDto(p))
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    // Endpoint que estava faltando
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> getById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id)
            .map(p -> ResponseEntity.ok(new PacienteResponse().toDto(p)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> update(
            @PathVariable Long id, @RequestBody PacienteRequestUpdate dto) {
        return pacienteService.updatePaciente(id, dto)
            .map(p -> ResponseEntity.ok(new PacienteResponse().toDto(p)))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = pacienteService.deletePaciente(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}