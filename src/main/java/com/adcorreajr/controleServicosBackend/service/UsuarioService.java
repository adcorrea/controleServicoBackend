package com.adcorreajr.controleServicosBackend.service;

import com.adcorreajr.controleServicosBackend.exceptions.UsuarioCadastradoException;
import com.adcorreajr.controleServicosBackend.model.entity.Usuario;
import com.adcorreajr.controleServicosBackend.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario salvar(Usuario usuario){
        if(usuarioRepository.existsByUsername(usuario.getUsername()))
            throw new UsuarioCadastradoException(usuario.getUsername());

        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));



        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
