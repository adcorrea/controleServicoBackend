package com.adcorreajr.controleServicosBackend.rest.controller;


import com.adcorreajr.controleServicosBackend.model.entity.Usuario;
import com.adcorreajr.controleServicosBackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping({"","/"})
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){

        usuarioService.salvar(usuario);
    }

}
