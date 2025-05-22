package br.com.fiap.controller;

import br.com.fiap.dto.profissional.ProfissionalRequestCreate;
import br.com.fiap.dto.profissional.ProfissionalRequestUpdate;
import br.com.fiap.dto.profissional.ProfissionalResponse;
import br.com.fiap.model.Profissional;
import br.com.fiap.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<ProfissionalResponse> create(
            @RequestBody ProfissionalRequestCreate dto) {
        Profissional profissional = profissionalService.createProfissional(dto);
        return ResponseEntity.status(201).body(new ProfissionalResponse().toDto(profissional));
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponse>> getAll() {
        List<ProfissionalResponse> response = profissionalService.getAll().stream()
                .map(p -> new ProfissionalResponse().toDto(p))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> getById(@PathVariable Long id) {
        return profissionalService.getProfissionalById(id)
                .map(p -> ResponseEntity.ok(new ProfissionalResponse().toDto(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> update(
            @PathVariable Long id, @RequestBody ProfissionalRequestUpdate dto) {
        return profissionalService.updateProfissional(id, dto)
                .map(p -> ResponseEntity.ok(new ProfissionalResponse().toDto(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = profissionalService.deleteProfissional(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}