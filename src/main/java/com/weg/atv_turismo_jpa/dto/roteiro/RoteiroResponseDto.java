package com.weg.atv_turismo_jpa.dto.roteiro;

import java.time.LocalDateTime;

public record RoteiroResponseDto(
    Long id,
    String local,
    LocalDateTime hora_saida,
    LocalDateTime hora_chegada,
    String capacidade_max
) {

}
