package com.adcorreajr.controleServicosBackend.rest.controller;


import com.adcorreajr.controleServicosBackend.model.entity.Cliente;
import com.adcorreajr.controleServicosBackend.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar (Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
