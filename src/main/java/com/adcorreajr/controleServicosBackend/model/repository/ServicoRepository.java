package com.adcorreajr.controleServicosBackend.model.repository;

import com.adcorreajr.controleServicosBackend.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
