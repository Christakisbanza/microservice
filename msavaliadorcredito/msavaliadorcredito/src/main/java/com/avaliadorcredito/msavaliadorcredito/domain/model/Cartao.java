package com.avaliadorcredito.msavaliadorcredito.domain.model;

import java.math.BigDecimal;

public class Cartao {

    private Long id;
    private String name;
    private String bandeiraCartao;
    private BigDecimal limiteBasico;

    public Cartao(Long id, String name, String bandeiraCartao, BigDecimal limiteBasico) {
        this.id = id;
        this.name = name;
        this.bandeiraCartao = bandeiraCartao;
        this.limiteBasico = limiteBasico;
    }

    public Cartao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(String bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public BigDecimal getLimiteBasico() {
        return limiteBasico;
    }

    public void setLimiteBasico(BigDecimal limiteBasico) {
        this.limiteBasico = limiteBasico;
    }
}
