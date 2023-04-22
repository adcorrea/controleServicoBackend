package com.adcorreajr.controleServicosBackend.rest.dto;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {
    private String descricao;

    private Integer idCliente;

    private String preco;

    private String data;

}