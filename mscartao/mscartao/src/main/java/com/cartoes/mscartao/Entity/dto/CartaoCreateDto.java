package com.cartoes.mscartao.Entity.dto;

import com.cartoes.mscartao.Entity.Cartao;
import lombok.Data;

import java.math.BigDecimal;


public class CartaoCreateDto {

    private String name;

    private BigDecimal renda;

    private Cartao.BandeiraCartao bandeiraCartao;

    private BigDecimal limiteBasico;

    public Cartao toCartao(){
        return new Cartao(name, bandeiraCartao, renda, limiteBasico);
    }

    public CartaoCreateDto() {
    }

    public CartaoCreateDto(String name, BigDecimal renda, Cartao.BandeiraCartao bandeiraCartao, BigDecimal limiteBasico) {
        this.name = name;
        this.renda = renda;
        this.bandeiraCartao = bandeiraCartao;
        this.limiteBasico = limiteBasico;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public Cartao.BandeiraCartao getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(Cartao.BandeiraCartao bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public BigDecimal getLimiteBasico() {
        return limiteBasico;
    }

    public void setLimiteBasico(BigDecimal limiteBasico) {
        this.limiteBasico = limiteBasico;
    }
}
