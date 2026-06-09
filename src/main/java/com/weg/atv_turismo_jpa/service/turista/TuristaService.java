package com.weg.atv_turismo_jpa.service.turista;

import java.util.List;

import com.weg.atv_turismo_jpa.dto.turista.TuristaRequestDto;
import com.weg.atv_turismo_jpa.dto.turista.TuristaResponseDto;

public interface TuristaService {
    TuristaResponseDto save(TuristaRequestDto turistaRequestDto);

    TuristaResponseDto get(Long id);

    List<TuristaResponseDto> getAll();

    TuristaResponseDto update(Long id, TuristaRequestDto turistaRequestDto);

    void delete(Long id);
}
