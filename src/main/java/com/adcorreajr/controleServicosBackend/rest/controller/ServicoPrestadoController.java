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

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
//@CrossOrigin("http://localhost:4200")
public class ServicoPrestadoController {
    
    @Autowired
    ServicoPrestadoRepository servicoPrestadoRepository;
    
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    BigDecimalConverter bigDecimalConverter;
    

    @PostMapping({"/",""})
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO servicoPrestadoDTO){

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

    @GetMapping({"","/"})
    public List<ServicoPrestado> obterTodos(){
        return servicoPrestadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ServicoPrestado obterPorId(@PathVariable Integer id){
        return servicoPrestadoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço Prestado não encontrado."));
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
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
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid ServicoPrestado servicoPrestadoAlterado){
        servicoPrestadoRepository.findById(id)
                .map(servicoPrestado -> {
                    servicoPrestadoAlterado.setId(servicoPrestado.getId());
                    servicoPrestadoRepository.save(servicoPrestadoAlterado);
                    return Void.TYPE;
                })
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço Prestado não encontrado.")
                );
    }


    @GetMapping("/busca")
    public List<ServicoPrestado> buscarNomeAndData(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ){
        return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }
    
}
