package br.com.fiap.dto.consulta;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ConsultaRequestCreate {
    
    @NotNull(message = "ID do profissional é obrigatório")
    private Long profissionalId;

    @NotNull(message = "ID do paciente é obrigatório")
    private Long pacienteId;

    @FutureOrPresent(message = "Data deve ser atual ou futura")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataConsulta;

    @NotNull(message = "Quantidade de horas é obrigatória")
    @Positive(message = "Deve ser maior que zero")
    private BigInteger quantidadeHoras;

    
    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public BigInteger getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(BigInteger quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
}