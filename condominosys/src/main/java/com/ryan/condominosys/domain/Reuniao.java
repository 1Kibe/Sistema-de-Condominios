package com.ryan.condominosys.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reuniao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private OffsetDateTime dataHora;
    private String local;

    @Enumerated(EnumType.STRING)
    private TipoReuniao tipoReuniao;

    @OneToOne
    @JoinColumn(name = "sindico_id")
    private Sindico sindicoResponsavel;

    @ManyToOne
    @JoinColumn(name = "condominio_id")
    private Condominio condominio;
}
