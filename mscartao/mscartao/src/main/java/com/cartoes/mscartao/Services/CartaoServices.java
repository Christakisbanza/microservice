package com.cartoes.mscartao.Services;


import com.cartoes.mscartao.Entity.Cartao;
import com.cartoes.mscartao.Repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoServices {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Transactional
    public void save(Cartao cartao){
        cartaoRepository.save(cartao);
    }

    public List<Cartao> getCartaoRendaMenorIgual(Long renda){
        BigDecimal rendaBigDecimal = BigDecimal.valueOf(renda);
        return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }

}
