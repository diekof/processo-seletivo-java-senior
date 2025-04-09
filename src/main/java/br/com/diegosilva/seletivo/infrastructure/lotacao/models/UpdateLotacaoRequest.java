package br.com.diegosilva.seletivo.infrastructure.lotacao.models;

import br.com.diegosilva.seletivo.application.lotacao.UpdateLotacaoUseCase;

import java.time.LocalDate;

public record UpdateLotacaoRequest(
        Long lotId,
        Long pesId,
        Long unidId,
        LocalDate lotDataLotacao,
        LocalDate lotDataRemocao,
        String lotPortaria
) implements UpdateLotacaoUseCase.Input {
}
