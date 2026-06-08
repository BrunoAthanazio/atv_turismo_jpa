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
@Table(name="turista")
@Getter
@Setter
public class Turista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="numero", nullable = false)
    private String numero;

    @Column(name="passaporte", nullable = false)
    private String passaporte;

    @Column(name="nacionalidade", nullable = false)
    private String nacionalidade;

    public Turista(String nome, String numero, String passaporte, String nacionalidade) {
        this.nome = nome;
        this.numero = numero;
        this.passaporte = passaporte;
        this.nacionalidade = nacionalidade;
    }
}
