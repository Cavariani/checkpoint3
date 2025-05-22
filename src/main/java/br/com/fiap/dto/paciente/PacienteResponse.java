package br.com.fiap.dto.paciente;

import br.com.fiap.model.Paciente;

import java.time.LocalDateTime;

public class PacienteResponse {
    private Long id;
    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefone_completo;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public PacienteResponse toDto(Paciente paciente) {
        PacienteResponse dto = new PacienteResponse();
        dto.setId(paciente.getId());
        dto.setNome(paciente.getNome());
        dto.setEndereco(paciente.getEndereco());
        dto.setBairro(paciente.getBairro());
        dto.setEmail(paciente.getEmail());
        dto.setTelefone_completo(paciente.getTelefone_completo());
        dto.setCreated_at(paciente.getCreated_at());
        dto.setUpdated_at(paciente.getUpdated_at());
        return dto;
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone_completo() {
        return telefone_completo;
    }

    public void setTelefone_completo(String telefone_completo) {
        this.telefone_completo = telefone_completo;
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