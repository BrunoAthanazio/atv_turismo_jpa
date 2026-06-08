package com.weg.atv_turismo_jpa.dto.turista;

public record TuristaRequestDto(
    String nome,
    String numero,
    String passaporte,
    String nacionalidade
) {

}
