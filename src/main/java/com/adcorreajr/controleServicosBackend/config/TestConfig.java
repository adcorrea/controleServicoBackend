package com.adcorreajr.controleServicosBackend.config;

import com.adcorreajr.controleServicosBackend.model.entity.Cliente;
import com.adcorreajr.controleServicosBackend.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class TestConfig implements CommandLineRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {
        Cliente cliente = Cliente.builder()
                .cpf("50886053072")
                .nome("Antonio Junior")
                .build();
        clienteRepository.save(cliente);

        clienteRepository.save(
                Cliente.builder()
                        .cpf("53122134705")
                        .nome("Joana D'arc")
                        .build()
        );

        clienteRepository.save(
                Cliente.builder()
                        .cpf("34524273158")
                        .nome("Tio Patinhas")
                        .build()
        );
    }

}
