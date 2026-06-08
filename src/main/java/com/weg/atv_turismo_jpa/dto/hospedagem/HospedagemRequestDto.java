package com.weg.atv_turismo_jpa.dto.hospedagem;

import java.time.LocalDateTime;

public record HospedagemRequestDto(
    String nome,
    LocalDateTime checkin,
    LocalDateTime checkout,
    String reserva
) {

}
