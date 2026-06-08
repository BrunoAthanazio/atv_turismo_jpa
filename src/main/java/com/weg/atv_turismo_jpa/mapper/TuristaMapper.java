package com.weg.atv_turismo_jpa.mapper;

import org.springframework.stereotype.Component;

import com.weg.atv_turismo_jpa.dto.turista.TuristaRequestDto;
import com.weg.atv_turismo_jpa.dto.turista.TuristaResponseDto;
import com.weg.atv_turismo_jpa.model.Turista;

@Component
public class TuristaMapper {
    public Turista toEntity(TuristaRequestDto turistaRequestDto){
        return new Turista(
            turistaRequestDto.nome(), 
            turistaRequestDto.numero(), 
            turistaRequestDto.passaporte(), 
            turistaRequestDto.nacionalidade());
    }

    public TuristaResponseDto toResponse(Turista turista){
        return new TuristaResponseDto(
            turista.getId(),
            turista.getNome(),
            turista.getNumero(),
            turista.getPassaporte(),
            turista.getNacionalidade()
        );
    }
}
