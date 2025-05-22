package br.com.fiap.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.dto.profissional.ProfissionalRequestCreate;
import br.com.fiap.dto.profissional.ProfissionalRequestUpdate;
import br.com.fiap.model.Profissional;

@Service
public class ProfissionalService {

    private List<Profissional> profissionais = new ArrayList<>();
    private Long sequence = 1L;

    public Profissional createProfissional(ProfissionalRequestCreate dto) {
        Profissional profissional = new Profissional();
        profissional.setId(sequence++);
        profissional.setNome(dto.getNome());
        profissional.setEspecialidade(dto.getEspecialidade());
        profissional.setValor_hora(dto.getValor_hora());
        profissional.setCreated_at(LocalDateTime.now());
        profissional.setUpdated_at(LocalDateTime.now());
        profissionais.add(profissional);
        return profissional;
    }

    public Optional<Profissional> getProfissionalById(Long id) {
        return profissionais.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Profissional> getAll() {
        return profissionais;
    }

    public Optional<Profissional> updateProfissional(Long id, ProfissionalRequestUpdate dto) {
        return profissionais.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(p -> {
                    if (dto.getNome() != null) p.setNome(dto.getNome());
                    if (dto.getEspecialidade() != null) p.setEspecialidade(dto.getEspecialidade());
                    if (dto.getValor_hora() != null) p.setValor_hora(dto.getValor_hora());
                    p.setUpdated_at(LocalDateTime.now());
                    return p;
                });
    }

    public boolean deleteProfissional(Long id) {
        return profissionais.removeIf(p -> p.getId().equals(id));
    }
}