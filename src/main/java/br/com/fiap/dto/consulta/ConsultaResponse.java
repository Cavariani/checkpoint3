package br.com.fiap.dto.consulta;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fiap.model.Consulta;

public class ConsultaResponse {
    
    private Long id;
    private String profissionalNome;
    private String pacienteNome;
    
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataConsulta;
    
    private String statusConsulta;
    private BigInteger quantidadeHoras;
    private BigDecimal valorConsulta;
    
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime createdAt;
    
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime updatedAt;

    public ConsultaResponse toDto(Consulta consulta) {
        this.id = consulta.getId();
        this.profissionalNome = consulta.getProfissional().getNome();
        this.pacienteNome = consulta.getPaciente().getNome();
        this.dataConsulta = consulta.getDataConsulta();
        this.statusConsulta = consulta.getStatusConsulta().name();
        this.quantidadeHoras = consulta.getQuantidadeHoras();
        this.valorConsulta = consulta.getValorConsulta();
        this.createdAt = consulta.getCreatedAt();
        this.updatedAt = consulta.getUpdatedAt();
        return this;
    }


    public Long getId() {
        return id;
    }

    public String getProfissionalNome() {
        return profissionalNome;
    }

    public String getPacienteNome() {
        return pacienteNome;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public BigInteger getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public BigDecimal getValorConsulta() {
        return valorConsulta;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}