package com.cartoes.mscartao.Entity.dto;

import com.cartoes.mscartao.Entity.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoCreateDto {

    private String name;

    private BigDecimal renda;

    private Cartao.BandeiraCartao bandeiraCartao;

    private BigDecimal limiteBasico;

    public Cartao toCartao(){
        return new Cartao(name, bandeiraCartao, renda, limiteBasico);
    }
}
