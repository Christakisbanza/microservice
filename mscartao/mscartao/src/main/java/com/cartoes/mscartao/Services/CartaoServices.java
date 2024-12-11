package com.cartoes.mscartao.Services;


import com.cartoes.mscartao.Repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoServices {

    @Autowired
    private CartaoRepository cartaoRepository;
}
