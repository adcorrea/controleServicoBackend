package com.adcorreajr.controleServicosBackend.rest.controller;

import com.adcorreajr.controleServicosBackend.model.entity.Cliente;
import com.adcorreajr.controleServicosBackend.model.entity.ServicoPrestado;
import com.adcorreajr.controleServicosBackend.model.repository.ClienteRepository;
import com.adcorreajr.controleServicosBackend.model.repository.ServicoPrestadoRepository;
import com.adcorreajr.controleServicosBackend.rest.dto.ServicoPrestadoDTO;
import com.adcorreajr.controleServicosBackend.util.BigDecimalConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {
    
    @Autowired
    ServicoPrestadoRepository servicoPrestadoRepository;
    
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    BigDecimalConverter bigDecimalConverter;
    

    @PostMapping({"/",""})
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO servicoPrestadoDTO){

        Cliente cliente = clienteRepository
                .findById(servicoPrestadoDTO.getIdCliente())
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente.")
                );

        ServicoPrestado servicoPrestado = ServicoPrestado.builder()
                .descricao(servicoPrestadoDTO.getDescricao())
                .valor(bigDecimalConverter.converter(servicoPrestadoDTO.getPreco()))
                .data(LocalDate.parse(servicoPrestadoDTO.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cliente(cliente)
                .build();

        return servicoPrestadoRepository.save(servicoPrestado);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@RequestParam Integer id){
        servicoPrestadoRepository.findById(id)
                .map(servicoPrestado -> {
                    servicoPrestadoRepository.delete(servicoPrestado);
                    return Void.TYPE;
                })
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço Prestado não encontrado.")
                );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@RequestParam Integer id, @RequestBody ServicoPrestado servicoPrestadoAlterado){
        servicoPrestadoRepository.findById(id)
                .map(servicoPrestado -> {
                    servicoPrestadoAlterado.setId(servicoPrestado.getId());
                    servicoPrestadoRepository.delete(servicoPrestadoAlterado);
                    return Void.TYPE;
                })
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço Prestado não encontrado.")
                );
    }



    
}
