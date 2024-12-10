package com.microservico.msclients.services;


import com.microservico.msclients.domain.Cliente;
import com.microservico.msclients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientServices {


    private final ClientRepository clientRepository;

    @Transactional
    public Cliente save(Cliente cliente){
        return clientRepository.save(cliente);
    }

    public Optional<Cliente> getByCpf(String cpf){
        return clientRepository.findByCpf(cpf);
    }
}
