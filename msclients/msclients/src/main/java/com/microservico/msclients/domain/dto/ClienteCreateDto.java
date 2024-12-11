package com.microservico.msclients.domain.dto;


import com.microservico.msclients.domain.Cliente;
import lombok.Data;


public class ClienteCreateDto {

    private String cpf;
    private String name;
    private Integer age;

    public Cliente toCliente(){
        return new Cliente(cpf, name, age);
    }

    public ClienteCreateDto() {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
