package com.avaliadorcredito.msavaliadorcredito.domain.model;

import java.math.BigDecimal;

public class CartaoCliente {
    private String name;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public CartaoCliente() {
    }

    public CartaoCliente(String name, String bandeira, BigDecimal limiteLiberado) {
        this.name = name;
        this.bandeira = bandeira;
        this.limiteLiberado = limiteLiberado;
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

    public BigDecimal getLimiteLiberado() {
        return limiteLiberado;
    }

    public void setLimiteLiberado(BigDecimal limiteLiberado) {
        this.limiteLiberado = limiteLiberado;
    }
}
