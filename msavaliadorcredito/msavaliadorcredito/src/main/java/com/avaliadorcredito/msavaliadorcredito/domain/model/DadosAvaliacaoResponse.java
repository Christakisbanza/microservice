package com.avaliadorcredito.msavaliadorcredito.domain.model;

import java.util.List;

public class DadosAvaliacaoResponse {

    private List<CartaoAprovado> cartaoAprovados;

    public DadosAvaliacaoResponse(List<CartaoAprovado> cartaoAprovados) {
        this.cartaoAprovados = cartaoAprovados;
    }

    public DadosAvaliacaoResponse() {
    }

    public List<CartaoAprovado> getCartaoAprovados() {
        return cartaoAprovados;
    }

    public void setCartaoAprovados(List<CartaoAprovado> cartaoAprovados) {
        this.cartaoAprovados = cartaoAprovados;
    }
}
