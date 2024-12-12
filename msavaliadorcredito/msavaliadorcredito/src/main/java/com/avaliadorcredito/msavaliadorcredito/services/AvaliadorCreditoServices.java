package com.avaliadorcredito.msavaliadorcredito.services;

import com.avaliadorcredito.msavaliadorcredito.domain.model.DadosCliente;
import com.avaliadorcredito.msavaliadorcredito.domain.model.SituacaoCliente;
import com.avaliadorcredito.msavaliadorcredito.feignclients.ClientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AvaliadorCreditoServices {

    @Autowired
    private ClientResource client;

    public SituacaoCliente obterSituacaoCliente(String cpf){
        ResponseEntity<DadosCliente> dadosCliente = client.getByCpf(cpf);
        return SituacaoCliente
                .builder()
                .cliente(dadosCliente.getBody())
                .build();
    }
}
