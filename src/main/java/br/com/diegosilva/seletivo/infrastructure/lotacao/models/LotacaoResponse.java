package br.com.diegosilva.seletivo.infrastructure.lotacao.models;

import java.time.LocalDate;

public record LotacaoResponse(
        Long lotId,
        String nomePessoa,
        String nomeUnidade,
        String siglaUnidade,
        LocalDate lotDataLotacao,
        LocalDate lotDataRemocao,
        String lotPortaria
) {
}
