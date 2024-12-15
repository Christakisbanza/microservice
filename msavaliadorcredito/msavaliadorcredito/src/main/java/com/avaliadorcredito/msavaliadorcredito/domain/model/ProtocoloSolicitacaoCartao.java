package com.avaliadorcredito.msavaliadorcredito.domain.model;

public class ProtocoloSolicitacaoCartao {
    private String protocolo;

    public ProtocoloSolicitacaoCartao(String protocolo) {
        this.protocolo = protocolo;
    }

    public ProtocoloSolicitacaoCartao() {
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }
}
