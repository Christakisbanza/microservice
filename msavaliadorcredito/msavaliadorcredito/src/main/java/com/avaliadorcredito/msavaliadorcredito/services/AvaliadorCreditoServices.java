package com.avaliadorcredito.msavaliadorcredito.services;

import com.avaliadorcredito.msavaliadorcredito.domain.model.*;
import com.avaliadorcredito.msavaliadorcredito.exception.DadosClienteNotFoundException;
import com.avaliadorcredito.msavaliadorcredito.exception.ErroComunicacaoMicroservicesException;
import com.avaliadorcredito.msavaliadorcredito.feignclients.CartaoResource;
import com.avaliadorcredito.msavaliadorcredito.feignclients.ClientResource;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public DadosAvaliacaoResponse realizarAvaliacaoCliente(String cpf, Long renda){
        try{
            ResponseEntity<DadosCliente> dadosCliente = client.getByCpf(cpf);
            ResponseEntity<List<Cartao>> listCartao = cartaoResource.getCartaoRendaMenorIgual(renda);

            List<Cartao> cartoes = listCartao.getBody();

            List<CartaoAprovado> cartoesAprovados = cartoes.stream().map(cartao -> {

                DadosCliente dadosCliente1 = dadosCliente.getBody();

                BigDecimal limiteBasico = cartao.getLimiteBasico();
                BigDecimal idadeBD = BigDecimal.valueOf(dadosCliente1.getAge());
                BigDecimal fator = idadeBD.divide(BigDecimal.valueOf(10));
                BigDecimal limiteAprovado = fator.multiply(limiteBasico);

                CartaoAprovado cartaoAprovado = new CartaoAprovado();
                cartaoAprovado.setName(cartao.getName());
                cartaoAprovado.setLimiteAprovado(limiteAprovado);

                return cartaoAprovado;
            }).toList();

            return new DadosAvaliacaoResponse(cartoesAprovados);
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
