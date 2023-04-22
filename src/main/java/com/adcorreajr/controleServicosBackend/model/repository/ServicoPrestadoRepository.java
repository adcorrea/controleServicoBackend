package com.adcorreajr.controleServicosBackend.model.repository;

import com.adcorreajr.controleServicosBackend.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
}
