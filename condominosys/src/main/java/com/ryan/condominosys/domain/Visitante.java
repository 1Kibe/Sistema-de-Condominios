package com.ryan.condominosys.domain;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Visitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private String nome;
    private String documento;
    private String telefone;
    private String placaDoVeiculo;
    private String modeloDoVeiculo;
    private String corDoVeiculo;

    private OffsetDateTime dataEntrada;
    private OffsetDateTime dataSaida;
    private Boolean autorizado;
}
