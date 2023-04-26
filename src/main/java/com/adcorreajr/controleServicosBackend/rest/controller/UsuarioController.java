package com.adcorreajr.controleServicosBackend.rest.controller;


import com.adcorreajr.controleServicosBackend.model.entity.Usuario;
import com.adcorreajr.controleServicosBackend.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping({"","/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario){
        return usuarioRepository.save(usuario);
    }

}
