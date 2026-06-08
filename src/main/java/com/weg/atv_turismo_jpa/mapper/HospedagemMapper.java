package com.weg.atv_turismo_jpa.mapper;

import org.springframework.stereotype.Component;

import com.weg.atv_turismo_jpa.dto.hospedagem.HospedagemRequestDto;
import com.weg.atv_turismo_jpa.dto.hospedagem.HospedagemResponseDto;
import com.weg.atv_turismo_jpa.model.Hospedagem;

@Component
public class HospedagemMapper {
    public Hospedagem toEntity(HospedagemRequestDto hospedagemRequestDto){
        return new Hospedagem(
            hospedagemRequestDto.nome(),
            hospedagemRequestDto.checkin(),
            hospedagemRequestDto.checkout(),
            hospedagemRequestDto.reserva()
        );
    }

    public HospedagemResponseDto toResponse(Hospedagem hospedagem){
        return new HospedagemResponseDto(
            hospedagem.getId(),
            hospedagem.getNome(),
            hospedagem.getCheckin(),
            hospedagem.getCheckout(),
            hospedagem.getReserva()
        );
    }
}
