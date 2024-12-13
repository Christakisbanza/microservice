package com.avaliadorcredito.msavaliadorcredito.controller;


import com.avaliadorcredito.msavaliadorcredito.domain.model.DadosAvaliacao;
import com.avaliadorcredito.msavaliadorcredito.domain.model.DadosAvaliacaoResponse;
import com.avaliadorcredito.msavaliadorcredito.domain.model.SituacaoCliente;
import com.avaliadorcredito.msavaliadorcredito.services.AvaliadorCreditoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes-credito")
public class AvaliadorCreditoController {

    @Autowired
    private AvaliadorCreditoServices avaliadorCreditoServices;

    @GetMapping
    public String status(){
        return "Ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity<SituacaoCliente> consultaSituacaoCliente(@RequestParam String cpf){

        SituacaoCliente situacaoCliente = avaliadorCreditoServices.obterSituacaoCliente(cpf);

        return ResponseEntity.ok(situacaoCliente);
    }

    @PostMapping
    public ResponseEntity<DadosAvaliacaoResponse> realizarAvaliacao(@RequestBody DadosAvaliacao dadosAvaliacao){
        DadosAvaliacaoResponse dadosAvaliacaoResponse = avaliadorCreditoServices
                .realizarAvaliacaoCliente(dadosAvaliacao.getCpf(),dadosAvaliacao.getReda());
        return ResponseEntity.ok(dadosAvaliacaoResponse);
    }

}
