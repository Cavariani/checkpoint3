package br.com.fiap.dto.profissional;

public class ProfissionalRequestCreate {
    private String nome;
    private String especialidade;
    private Integer valor_hora;

    // Getters and Setters
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
}