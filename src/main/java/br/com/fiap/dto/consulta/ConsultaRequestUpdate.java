package br.com.fiap.dto.consulta;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fiap.model.StatusConsulta;
import jakarta.validation.constraints.Positive;

public class ConsultaRequestUpdate {
    
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataConsulta;

    private StatusConsulta statusConsulta;

    @Positive(message = "Deve ser maior que zero")
    private BigInteger quantidadeHoras;

    // Getters e Setters
    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public BigInteger getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(BigInteger quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
}