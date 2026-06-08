package com.weg.atv_turismo_jpa.mapper;

import org.springframework.stereotype.Component;

import com.weg.atv_turismo_jpa.dto.transporte.TransporteRequestDto;
import com.weg.atv_turismo_jpa.dto.transporte.TransporteResponseDto;
import com.weg.atv_turismo_jpa.model.Transporte;

@Component
public class TransporteMapper {
    public Transporte toEntity(TransporteRequestDto transporteRequestDto){
        return new Transporte(
            transporteRequestDto.nome(),
            transporteRequestDto.partida(),
            transporteRequestDto.destino(),
            transporteRequestDto.tipo()
        );
    }

    public TransporteResponseDto toResponse(Transporte transporte){
        return new TransporteResponseDto(
            transporte.getId(),
            transporte.getNome(),
            transporte.getPartida(),
            transporte.getDestino(),
            transporte.getTipo()
        );
    }
}
