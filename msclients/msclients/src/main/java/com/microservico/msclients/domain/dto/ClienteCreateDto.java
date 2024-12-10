package com.microservico.msclients.domain.dto;


import com.microservico.msclients.domain.Cliente;
import lombok.Data;

@Data
public class ClienteCreateDto {

    private String cpf;
    private String name;
    private Integer age;

    public Cliente toCliente(){
        return new Cliente(cpf, name, age);
    }
}
