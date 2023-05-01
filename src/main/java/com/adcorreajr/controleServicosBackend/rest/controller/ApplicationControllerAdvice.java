package com.adcorreajr.controleServicosBackend.rest.controller;


import com.adcorreajr.controleServicosBackend.exceptions.UsuarioCadastradoException;
import com.adcorreajr.controleServicosBackend.rest.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErrors(MethodArgumentNotValidException ex){
        BindingResult bindResult = ex.getBindingResult();
        List<String> messages = bindResult.getAllErrors().stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        return  new ApiErrors(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex){
        String messageError = ex.getMessage();
        HttpStatus codigoStatus = ex.getStatus();
        ApiErrors errors = new ApiErrors(messageError);
        return new ResponseEntity(errors, codigoStatus);
    }


    @ExceptionHandler(UsuarioCadastradoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleUsuarioCadastradoException(UsuarioCadastradoException ex){
        return new ApiErrors(ex.getMessage());
    }
}
