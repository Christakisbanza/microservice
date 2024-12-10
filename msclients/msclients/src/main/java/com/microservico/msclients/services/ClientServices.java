package com.microservico.msclients.services;


import com.microservico.msclients.domain.Cliente;
import com.microservico.msclients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void save(Cliente cliente){
        clientRepository.save(cliente);
    }

    public Optional<Cliente> getByCpf(String cpf){
        return clientRepository.findByCpf(cpf);
    }
}
