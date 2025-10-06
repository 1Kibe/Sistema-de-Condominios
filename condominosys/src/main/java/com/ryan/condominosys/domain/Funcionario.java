package com.ryan.condominosys.domain;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String cargo;
    private Boolean status;

    private OffsetDateTime dataAdmissao;
    private OffsetDateTime dataDemissao;
    private Boolean usuarioSistema;

    @ManyToMany
    @JoinColumn(name = "condominio_id")
    private Condominio condominio;
}
