package br.com.diegosilva.seletivo.infrastructure.lotacao.models;

import br.com.diegosilva.seletivo.application.lotacao.CreateLotacaoUseCase;

import java.time.LocalDate;

public record CreateLotacaoRequest(
        Long pesId,
        Long unidId,
        LocalDate lotDataLotacao,
        LocalDate lotDataRemocao,
        String lotPortaria
) implements CreateLotacaoUseCase.Input {


}
