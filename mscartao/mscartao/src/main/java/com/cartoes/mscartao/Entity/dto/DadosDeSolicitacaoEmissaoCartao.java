package com.cartoes.mscartao.Entity.dto;

import java.math.BigDecimal;

public class DadosDeSolicitacaoEmissaoCartao {
    private Long id;
    private String cpf;
    private String endereco;
    private BigDecimal limiteLiberado;

    public DadosDeSolicitacaoEmissaoCartao() {
    }

    public DadosDeSolicitacaoEmissaoCartao(Long id, String cpf, String endereco, BigDecimal limiteLiberado) {
        this.id = id;
        this.cpf = cpf;
        this.endereco = endereco;
        this.limiteLiberado = limiteLiberado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getLimiteLiberado() {
        return limiteLiberado;
    }

    public void setLimiteLiberado(BigDecimal limiteLiberado) {
        this.limiteLiberado = limiteLiberado;
    }
}
