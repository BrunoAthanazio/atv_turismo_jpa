package com.weg.atv_turismo_jpa.dto.guia;

public record GuiaRequestDto(
    String nome,
    Long idade,
    String especialidade,
    String nacionalidade
) {

}
