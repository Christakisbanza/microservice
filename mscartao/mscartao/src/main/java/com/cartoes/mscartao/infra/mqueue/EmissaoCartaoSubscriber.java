package com.cartoes.mscartao.infra.mqueue;

import com.cartoes.mscartao.Entity.Cartao;
import com.cartoes.mscartao.Entity.CartaoCliente;
import com.cartoes.mscartao.Entity.dto.DadosDeSolicitacaoEmissaoCartao;
import com.cartoes.mscartao.Repository.CartaoClienteRepository;
import com.cartoes.mscartao.Repository.CartaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoSubscriber {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CartaoClienteRepository cartaoClienteRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload){
        try {
            ObjectMapper mapper = new ObjectMapper();

            DadosDeSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosDeSolicitacaoEmissaoCartao.class);
            Cartao cartao = cartaoRepository.findById(dados.getId()).orElseThrow();

            CartaoCliente cliente = new CartaoCliente();

            cliente.setCartao(cartao);
            cliente.setCpf(dados.getCpf());
            cliente.setLimite(dados.getLimiteLiberado());

            cartaoClienteRepository.save(cliente);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
