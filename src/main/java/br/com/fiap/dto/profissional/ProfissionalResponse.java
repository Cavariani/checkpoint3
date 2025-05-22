package br.com.fiap.dto.profissional;

import br.com.fiap.model.Profissional;

import java.time.LocalDateTime;

public class ProfissionalResponse {
    private Long id;
    private String nome;
    private String especialidade;
    private Integer valor_hora;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public ProfissionalResponse toDto(Profissional profissional) {
        ProfissionalResponse dto = new ProfissionalResponse();
        dto.setId(profissional.getId());
        dto.setNome(profissional.getNome());
        dto.setEspecialidade(profissional.getEspecialidade());
        dto.setValor_hora(profissional.getValor_hora());
        dto.setCreated_at(profissional.getCreated_at());
        dto.setUpdated_at(profissional.getUpdated_at());
        return dto;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(Integer valor_hora) {
        this.valor_hora = valor_hora;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}