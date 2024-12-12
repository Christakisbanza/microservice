package com.cartoes.mscartao.Controller;


import com.cartoes.mscartao.Entity.Cartao;
import com.cartoes.mscartao.Entity.dto.CartaoCreateDto;
import com.cartoes.mscartao.Services.CartaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoServices cartaoServices;

    @GetMapping
    public String status(){
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CartaoCreateDto cartaoCreateDto){
        Cartao cartao = cartaoCreateDto.toCartao();
        cartaoServices.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartaoRendaMenorIgual(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoServices.getCartaoRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }
}
