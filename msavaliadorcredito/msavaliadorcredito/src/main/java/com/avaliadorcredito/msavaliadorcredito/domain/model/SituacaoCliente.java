package com.avaliadorcredito.msavaliadorcredito.domain.model;

import lombok.Builder;

import java.util.List;

@Builder
public class SituacaoCliente {

    private DadosCliente cliente;
    private List<CartaoCliente> cartaoClientes;

    public SituacaoCliente() {
    }

    public SituacaoCliente(DadosCliente cliente, List<CartaoCliente> cartaoClientes) {
        this.cliente = cliente;
        this.cartaoClientes = cartaoClientes;
    }

    public DadosCliente getCliente() {
        return cliente;
    }

    public void setCliente(DadosCliente cliente) {
        this.cliente = cliente;
    }

    public List<CartaoCliente> getCartaoClientes() {
        return cartaoClientes;
    }

    public void setCartaoClientes(List<CartaoCliente> cartaoClientes) {
        this.cartaoClientes = cartaoClientes;
    }
}
