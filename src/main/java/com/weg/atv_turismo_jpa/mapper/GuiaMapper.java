package com.weg.atv_turismo_jpa.mapper;

import org.springframework.stereotype.Component;

import com.weg.atv_turismo_jpa.dto.guia.GuiaRequestDto;
import com.weg.atv_turismo_jpa.dto.guia.GuiaResponseDto;
import com.weg.atv_turismo_jpa.model.Guia;

@Component
public class GuiaMapper {
    public Guia toEntity(GuiaRequestDto guiaRequestDto){
        return new Guia(
            guiaRequestDto.nome(),
            guiaRequestDto.idade(),
            guiaRequestDto.especialidade(),
            guiaRequestDto.nacionalidade()
        );
    }

    public GuiaResponseDto toResponseDto(Guia guia){
        return new GuiaResponseDto(
            guia.getId(),
            guia.getNome(),
            guia.getIdade(),
            guia.getEspecialidade(),
            guia.getNacionalidade()
        );
    }
}
