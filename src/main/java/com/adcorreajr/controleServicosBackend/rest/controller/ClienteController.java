package com.adcorreajr.controleServicosBackend.rest.controller;


import com.adcorreajr.controleServicosBackend.model.entity.Cliente;
import com.adcorreajr.controleServicosBackend.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping({"/",""})
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar (@RequestBody @Valid Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping({"/",""})
    @ResponseStatus(HttpStatus.CREATED)
    public List<Cliente> buscarTodos (){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Cliente buscarPorId(@PathVariable Integer id){
        return  clienteRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleterPorId(@PathVariable Integer id){
        clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));

    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable Integer id, @RequestBody @Valid Cliente cliente){
        clienteRepository.findById(id)
                .map(clienteNew -> {
                    cliente.setId(clienteNew.getId());
                    clienteRepository.save(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));

    }
}
