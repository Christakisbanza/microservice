package com.avaliadorcredito.msavaliadorcredito.domain.model;

import java.math.BigDecimal;

public class CartaoAprovado {
    private String name;
    private String bandeira;
    private BigDecimal limiteAprovado;

    public CartaoAprovado() {
    }

    public CartaoAprovado(String name, String bandeira, BigDecimal limiteAprovado) {
        this.name = name;
        this.bandeira = bandeira;
        this.limiteAprovado = limiteAprovado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public BigDecimal getLimiteAprovado() {
        return limiteAprovado;
    }

    public void setLimiteAprovado(BigDecimal limiteAprovado) {
        this.limiteAprovado = limiteAprovado;
    }
}
