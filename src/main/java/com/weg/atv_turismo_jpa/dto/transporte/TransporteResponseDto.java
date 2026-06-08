package com.weg.atv_turismo_jpa.dto.transporte;

public record TransporteResponseDto(
    Long id,
    String nome,
    String partida,
    String destino,
    String tipo
) {

}
