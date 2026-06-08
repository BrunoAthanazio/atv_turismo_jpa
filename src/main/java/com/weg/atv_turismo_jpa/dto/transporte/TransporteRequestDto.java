package com.weg.atv_turismo_jpa.dto.transporte;

public record TransporteRequestDto(
    String nome,
    String partida,
    String destino,
    String tipo
) {

}
