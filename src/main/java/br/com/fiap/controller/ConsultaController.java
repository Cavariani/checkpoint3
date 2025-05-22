package br.com.fiap.controller;

import br.com.fiap.dto.consulta.ConsultaRequestCreate;
import br.com.fiap.dto.consulta.ConsultaRequestUpdate;
import br.com.fiap.dto.consulta.ConsultaResponse;
import br.com.fiap.model.Consulta;
import br.com.fiap.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponse> create(@RequestBody ConsultaRequestCreate dto) {
        Consulta consulta = consultaService.createConsulta(dto);
        return ResponseEntity.status(201).body(new ConsultaResponse().toDto(consulta));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> getAll(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate data_de,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate data_ate) {
        
        List<ConsultaResponse> response = consultaService.filterConsultas(status, data_de, data_ate)
                .stream()
                .map(c -> new ConsultaResponse().toDto(c))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> getById(@PathVariable Long id) {
        return consultaService.getConsultaById(id)
                .map(c -> ResponseEntity.ok(new ConsultaResponse().toDto(c)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> update(
            @PathVariable Long id, @RequestBody ConsultaRequestUpdate dto) {
        return consultaService.updateConsulta(id, dto)
                .map(c -> ResponseEntity.ok(new ConsultaResponse().toDto(c)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = consultaService.deleteConsulta(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}