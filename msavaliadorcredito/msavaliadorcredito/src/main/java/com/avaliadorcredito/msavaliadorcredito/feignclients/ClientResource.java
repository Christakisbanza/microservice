package com.avaliadorcredito.msavaliadorcredito.feignclients;

import com.avaliadorcredito.msavaliadorcredito.domain.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(value = "msclients", path = "/clients")
public interface ClientResource {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCliente> getByCpf(@RequestParam String cpf);
}
