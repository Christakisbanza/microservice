package com.cartoes.mscartao.Entity.dto;

import com.cartoes.mscartao.Entity.CartaoCliente;

import java.math.BigDecimal;

public class CartaoClienteResponseDto {

    private String name;
    private String bandiera;
    private BigDecimal limiteLiberado;

    public static CartaoClienteResponseDto toDto(CartaoCliente cliente){
        return new CartaoClienteResponseDto(
                cliente.getCartao().getName(),
                cliente.getCartao().getBandeiraCartao().toString(),
                cliente.getLimite()
        );
    }
    public CartaoClienteResponseDto() {
    }

    public CartaoClienteResponseDto(String name, String bandiera, BigDecimal limiteLiberado) {
        this.name = name;
        this.bandiera = bandiera;
        this.limiteLiberado = limiteLiberado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBandiera() {
        return bandiera;
    }

    public void setBandiera(String bandiera) {
        this.bandiera = bandiera;
    }

    public BigDecimal getLimiteLiberado() {
        return limiteLiberado;
    }

    public void setLimiteLiberado(BigDecimal limiteLiberado) {
        this.limiteLiberado = limiteLiberado;
    }
}
