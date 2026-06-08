package com.weg.atv_turismo_jpa.dto.guia;

public record GuiaResponseDto(
    Long id,
    String nome,
    Long idade,
    String especialidade,
    String nacionalidade
) {

}
