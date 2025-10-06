package com.ryan.condominosys.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoCondominio tipo;

    private String cnpj;
    private String telefone;


    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    private List<Morador> moradores;
 
    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    private List<Bloco> blocos;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    private List<Area> areas;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    private List<Regras> regras;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    private List<Sindico> sidicos;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    private List<Funcionario> Funcionario;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    private List<Reuniao> reunioes;


    //talves saia
    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    private List<Visitante> visitantes;



}
