package com.weg.atv_turismo_jpa.model;

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
@Table(name = "transporte")
@Getter
@Setter
public class Transporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "partida", nullable = false)
    private String partida;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    public Transporte(String nome, String partida, String destino, String tipo) {
        this.nome = nome;
        this.partida = partida;
        this.destino = destino;
        this.tipo = tipo;
    }
}
