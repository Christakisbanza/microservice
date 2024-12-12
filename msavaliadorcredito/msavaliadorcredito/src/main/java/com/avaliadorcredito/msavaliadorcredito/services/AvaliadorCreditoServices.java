package com.avaliadorcredito.msavaliadorcredito.services;

import com.avaliadorcredito.msavaliadorcredito.domain.model.CartaoCliente;
import com.avaliadorcredito.msavaliadorcredito.domain.model.DadosCliente;
import com.avaliadorcredito.msavaliadorcredito.domain.model.SituacaoCliente;
import com.avaliadorcredito.msavaliadorcredito.feignclients.CartaoResource;
import com.avaliadorcredito.msavaliadorcredito.feignclients.ClientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliadorCreditoServices {

    @Autowired
    private ClientResource client;

    @Autowired
    private CartaoResource cartaoResource;


    public SituacaoCliente obterSituacaoCliente(String cpf){
        ResponseEntity<DadosCliente> dadosCliente = client.getByCpf(cpf);
        ResponseEntity<List<CartaoCliente>> cartoesCliente = cartaoResource.getCartaoByCliente(cpf);

        return SituacaoCliente.toSituacaoCliente(dadosCliente.getBody(), cartoesCliente.getBody());
    }
}
