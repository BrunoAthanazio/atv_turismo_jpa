package com.weg.atv_turismo_jpa.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roteiro")
@Getter
@Setter
public class Roteiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "hora_chegada", nullable = false)
    private LocalDate hora_chegada;

    @Column(name = "hora_saida", nullable = false)
    private LocalDate hora_saida;

    @Column(name = "capacidade_max", nullable = false)
    private String capacidade_max;

    public Roteiro(String local, LocalDate hora_chegada, LocalDate hora_saida, String capacidade_max) {
        this.local = local;
        this.hora_chegada = hora_chegada;
        this.hora_saida = hora_saida;
        this.capacidade_max = capacidade_max;
    }

    
}
