package com.weg.atv_turismo_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weg.atv_turismo_jpa.model.Roteiro;

@Repository
public interface RoteiroRepository extends JpaRepository<Roteiro, Long>{
    boolean existsByLocal(String local);
}
