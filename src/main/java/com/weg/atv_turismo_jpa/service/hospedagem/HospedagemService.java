package com.weg.atv_turismo_jpa.service.hospedagem;

import java.util.List;

import com.weg.atv_turismo_jpa.dto.hospedagem.HospedagemRequestDto;
import com.weg.atv_turismo_jpa.dto.hospedagem.HospedagemResponseDto;

public interface HospedagemService {
    HospedagemResponseDto save(HospedagemRequestDto ospedagemRequestDto);

    HospedagemResponseDto get(Long id);

    List<HospedagemResponseDto> getAll();

    HospedagemResponseDto update(Long id, HospedagemRequestDto hospedagemRequestDto);

    void delete(Long id);
}
