package com.adcorreajr.controleServicosBackend.exceptions;

public class UsuarioCadastradoException extends RuntimeException{

    public UsuarioCadastradoException(String login){
        super("Login " + login + " ja cadastrado.");
    }
}
