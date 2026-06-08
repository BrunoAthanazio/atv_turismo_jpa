package com.weg.atv_turismo_jpa.dto.turista;

public record TuristaResponseDto(
    Long id,
    String nome,
    String numero,
    String passaporte,
    String nacionalidade
) {

}
