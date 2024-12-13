package com.avaliadorcredito.msavaliadorcredito.controller;


import com.avaliadorcredito.msavaliadorcredito.domain.model.SituacaoCliente;
import com.avaliadorcredito.msavaliadorcredito.services.AvaliadorCreditoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
