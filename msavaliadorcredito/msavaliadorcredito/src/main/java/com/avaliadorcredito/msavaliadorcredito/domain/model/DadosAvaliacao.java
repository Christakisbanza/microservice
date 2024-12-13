package com.avaliadorcredito.msavaliadorcredito.domain.model;

public class DadosAvaliacao {

    private String cpf;
    private Long reda;

    public DadosAvaliacao() {
    }

    public DadosAvaliacao(String cpf, Long reda) {
        this.cpf = cpf;
        this.reda = reda;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getReda() {
        return reda;
    }

    public void setReda(Long reda) {
        this.reda = reda;
    }
}
