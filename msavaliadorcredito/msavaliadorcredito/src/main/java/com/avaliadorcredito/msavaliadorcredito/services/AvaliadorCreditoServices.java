package com.avaliadorcredito.msavaliadorcredito.services;

import com.avaliadorcredito.msavaliadorcredito.domain.model.CartaoCliente;
import com.avaliadorcredito.msavaliadorcredito.domain.model.DadosCliente;
import com.avaliadorcredito.msavaliadorcredito.domain.model.SituacaoCliente;
import com.avaliadorcredito.msavaliadorcredito.exception.DadosClienteNotFoundException;
import com.avaliadorcredito.msavaliadorcredito.exception.ErroComunicacaoMicroservicesException;
import com.avaliadorcredito.msavaliadorcredito.feignclients.CartaoResource;
import com.avaliadorcredito.msavaliadorcredito.feignclients.ClientResource;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        try {
            ResponseEntity<DadosCliente> dadosCliente = client.getByCpf(cpf);
            ResponseEntity<List<CartaoCliente>> cartoesCliente = cartaoResource.getCartaoByCliente(cpf);

            return SituacaoCliente.toSituacaoCliente(dadosCliente.getBody(), cartoesCliente.getBody());
        }
        catch (FeignException.FeignClientException e){
            if(HttpStatus.NOT_FOUND.value() == e.status()){
                throw new DadosClienteNotFoundException("Dados do cliente não encontrados para o cpf informado !");
            }else{
                throw new ErroComunicacaoMicroservicesException(e.getMessage(), e.status());
            }
        }

    }

}
