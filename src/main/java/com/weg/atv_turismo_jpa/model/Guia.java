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
@Table(name = "guia")
@Getter
@Setter
public class Guia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "idade", nullable = false)
    private Long idade;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @Column(name = "nacionalidade", nullable = false)
    private String nacionalidade;

    public Guia(String nome, Long idade, String especialidade, String nacionalidade) {
        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
        this.nacionalidade = nacionalidade;
    }
}
