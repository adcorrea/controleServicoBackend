package com.adcorreajr.controleServicosBackend.model.repository;

import com.adcorreajr.controleServicosBackend.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
