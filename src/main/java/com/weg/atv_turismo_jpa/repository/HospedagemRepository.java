package com.weg.atv_turismo_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weg.atv_turismo_jpa.model.Hospedagem;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Long>{

}
