package com.weg.atv_turismo_jpa.service.roteiro;

import java.util.List;

import com.weg.atv_turismo_jpa.dto.roteiro.RoteiroRequestDto;
import com.weg.atv_turismo_jpa.dto.roteiro.RoteiroResponseDto;

public interface RoteiroService {
    RoteiroResponseDto save(RoteiroRequestDto roteiroRequestDto);

    RoteiroResponseDto get(Long id);

    List<RoteiroResponseDto> getAll();

    RoteiroResponseDto update(Long id, RoteiroRequestDto roteiroRequestDto);

    void delete(Long id);
}
