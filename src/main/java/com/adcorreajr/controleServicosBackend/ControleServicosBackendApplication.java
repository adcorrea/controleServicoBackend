package com.adcorreajr.controleServicosBackend;

import com.adcorreajr.controleServicosBackend.model.entity.Cliente;
import com.adcorreajr.controleServicosBackend.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ControleServicosBackendApplication {


	/*@Bean
	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository){
		return args -> {
			Cliente cliente = Cliente.builder()
					.cpf("50886053072")
					.nome("Antonio Junior")
					.build();
			clienteRepository.save(cliente);
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ControleServicosBackendApplication.class, args);
	}

}
