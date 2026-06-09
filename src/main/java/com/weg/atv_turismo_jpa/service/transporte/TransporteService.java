package com.weg.atv_turismo_jpa.service.transporte;

import java.util.List;

import com.weg.atv_turismo_jpa.dto.transporte.TransporteRequestDto;
import com.weg.atv_turismo_jpa.dto.transporte.TransporteResponseDto;

public interface TransporteService {
    TransporteResponseDto save(TransporteRequestDto transporteRequestDto);

    TransporteResponseDto get(Long id);

    List<TransporteResponseDto> getAll();

    TransporteResponseDto update(Long id, TransporteRequestDto transporteRequestDto);

    void delete(Long id);
}
