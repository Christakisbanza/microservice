package com.microservico.msclients.controller;


import com.microservico.msclients.domain.Cliente;
import com.microservico.msclients.domain.dto.ClienteCreateDto;
import com.microservico.msclients.services.ClientServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServices clientServices;


    @PostMapping
    public ResponseEntity<Void> save (@RequestBody ClienteCreateDto clienteCreateDto){
        Cliente cliente = clienteCreateDto.toCliente();
        clientServices.save(cliente);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Optional<Cliente>> getByCpf(@RequestParam("cpf") String cpf){
        Optional<Cliente> client = clientServices.getByCpf(cpf);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

}
