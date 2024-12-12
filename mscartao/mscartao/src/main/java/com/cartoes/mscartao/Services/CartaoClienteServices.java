package com.cartoes.mscartao.Services;


import com.cartoes.mscartao.Entity.CartaoCliente;
import com.cartoes.mscartao.Repository.CartaoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartaoClienteServices {

    @Autowired
    private CartaoClienteRepository cartaoClienteRepository;

    @Transactional
    public List<CartaoCliente> getByCpf(String cpf){
        return cartaoClienteRepository.findByCpf(cpf);
    }
}
