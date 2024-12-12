package com.avaliadorcredito.msavaliadorcredito.domain.model;


import java.util.List;


public class SituacaoCliente {

    private DadosCliente cliente;
    private List<CartaoCliente> cartaoClientes;




    public SituacaoCliente() {
    }

    public SituacaoCliente(DadosCliente cliente, List<CartaoCliente> cartaoClientes) {
        this.cliente = cliente;
        this.cartaoClientes = cartaoClientes;
    }

    public SituacaoCliente(DadosCliente cliente) {
        this.cliente = cliente;
    }




    public static SituacaoCliente toSituacaoCliente(DadosCliente dadosCliente){
        return new SituacaoCliente(dadosCliente);
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
