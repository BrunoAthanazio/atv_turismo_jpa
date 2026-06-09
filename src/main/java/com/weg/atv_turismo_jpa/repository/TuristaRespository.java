package com.weg.atv_turismo_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weg.atv_turismo_jpa.model.Turista;

@Repository
public interface TuristaRespository extends JpaRepository<Turista, Long>{
    boolean existsByNome(String nome);
}
