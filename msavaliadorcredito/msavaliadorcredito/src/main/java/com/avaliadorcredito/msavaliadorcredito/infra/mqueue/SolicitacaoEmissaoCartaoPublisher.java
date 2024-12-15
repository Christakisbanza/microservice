package com.avaliadorcredito.msavaliadorcredito.infra.mqueue;

import com.avaliadorcredito.msavaliadorcredito.domain.model.DadosDeSolicitacaoEmissaoCartao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoEmissaoCartaoPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queueEmissaoCartao;

    public void solicitarCartao(DadosDeSolicitacaoEmissaoCartao dados)throws JsonProcessingException{
        String json = convertIntoJson(dados);
        rabbitTemplate.convertAndSend(queueEmissaoCartao.getName(), json);
    }

    private String convertIntoJson(DadosDeSolicitacaoEmissaoCartao dados) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dados);
    }

}
