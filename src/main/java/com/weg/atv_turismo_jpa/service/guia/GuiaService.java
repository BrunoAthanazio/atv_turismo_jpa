package com.weg.atv_turismo_jpa.service.guia;

import java.util.List;

import com.weg.atv_turismo_jpa.dto.guia.GuiaRequestDto;
import com.weg.atv_turismo_jpa.dto.guia.GuiaResponseDto;

public interface GuiaService {
    GuiaResponseDto save(GuiaRequestDto guiaRequestDto);

    GuiaResponseDto get(Long id);

    List<GuiaResponseDto> getAll();

    GuiaResponseDto update(Long id, GuiaRequestDto guiaRequestDto);

    void delete(Long id);
}
