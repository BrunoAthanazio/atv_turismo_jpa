package com.weg.atv_turismo_jpa.model;

import java.time.LocalDateTime;

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
@Table(name = "hospedagem")
@Getter
@Setter
public class Hospedagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "checkin", nullable = false)
    private LocalDateTime checkin;

    @Column(name = "checkout", nullable = false)
    private LocalDateTime checkout;

    @Column(name = "reserva", nullable = false)
    private String reserva;

    public Hospedagem(String nome, LocalDateTime checkin, LocalDateTime checkout, String reserva) {
        this.nome = nome;
        this.checkin = checkin;
        this.checkout = checkout;
        this.reserva = reserva;
    }

    
}
