package com.cartoes.mscartao.Controller;


import com.cartoes.mscartao.Services.CartaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoServices cartaoServices;

    @GetMapping
    public String status(){
        return "Ok";
    }
}
