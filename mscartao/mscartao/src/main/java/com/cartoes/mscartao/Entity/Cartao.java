package com.cartoes.mscartao.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeiraCartao;

    private BigDecimal renda;

    private BigDecimal limiteBasico;


    public enum BandeiraCartao{
        MASTERCARD,
        VISA;
    }

    public Cartao(String name, BandeiraCartao bandeiraCartao, BigDecimal renda, BigDecimal limiteBasico) {
        this.name = name;
        this.bandeiraCartao = bandeiraCartao;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }

    public Cartao() {
    }

    public Cartao(Long id, BandeiraCartao bandeiraCartao, String name, BigDecimal renda, BigDecimal limiteBasico) {
        this.id = id;
        this.bandeiraCartao = bandeiraCartao;
        this.name = name;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
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

    public BandeiraCartao getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(BandeiraCartao bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public BigDecimal getLimiteBasico() {
        return limiteBasico;
    }

    public void setLimiteBasico(BigDecimal limiteBasico) {
        this.limiteBasico = limiteBasico;
    }
}
