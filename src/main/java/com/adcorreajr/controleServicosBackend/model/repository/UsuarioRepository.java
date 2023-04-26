package com.adcorreajr.controleServicosBackend.model.repository;

import com.adcorreajr.controleServicosBackend.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
