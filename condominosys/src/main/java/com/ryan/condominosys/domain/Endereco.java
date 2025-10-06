package com.ryan.condominosys.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificacaoNome;

    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;
    
    private String rua;
    private Integer numero;
    private String cep;
    private String bairro;
    private String cidade;

    @OneToOne
    @JoinColumn(name = "andar_id")
     private Andar andar;

    @OneToOne
    @JoinColumn(name = "bloco_id")
     private Bloco bloco;

    @OneToOne
    @JoinColumn(name = "residencia_id")
     private Residencia residencia;

    @OneToOne
    @JoinColumn(name = "condominio_id")
     private Condominio condominio;
    

}   
