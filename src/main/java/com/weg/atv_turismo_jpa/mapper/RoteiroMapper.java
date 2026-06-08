package com.weg.atv_turismo_jpa.mapper;

import org.springframework.stereotype.Component;

import com.weg.atv_turismo_jpa.dto.roteiro.RoteiroRequestDto;
import com.weg.atv_turismo_jpa.dto.roteiro.RoteiroResponseDto;
import com.weg.atv_turismo_jpa.model.Roteiro;

@Component
public class RoteiroMapper {
    public Roteiro toEntity(RoteiroRequestDto roteiroRequestDto){
        return new Roteiro(
            roteiroRequestDto.local(),
            roteiroRequestDto.hora_chegada(),
            roteiroRequestDto.hora_saida(),
            roteiroRequestDto.capacidade_max()
        );
    }

    public RoteiroResponseDto toResponseDTO(Roteiro roteiro){
        return new RoteiroResponseDto(
            roteiro.getId(),
            roteiro.getLocal(),
            roteiro.getHora_saida(),
            roteiro.getHora_chegada(),
            roteiro.getCapacidade_max()
        );
    }
}
