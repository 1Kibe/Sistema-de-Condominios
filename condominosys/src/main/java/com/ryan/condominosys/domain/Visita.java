package com.ryan.condominosys.domain;

import java.time.OffsetDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OffsetDateTime dataHoraEntrada;
    private OffsetDateTime dataHoraSaida;
    private String extra;

    @OneToMany(mappedBy = "visita", cascade = CascadeType.ALL)
    private List<Visitante> visitantes;

    @OneToOne
    @JoinColumn(name = "morador_id")
    private Morador moradorDaVisita;

    @OneToOne
    @JoinColumn(name = "residencia_id")
    private Residencia residenciaDaVisita;

    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionarioQueRecebeu;


}
