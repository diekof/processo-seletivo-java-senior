package br.com.diegosilva.seletivo.domain.lotacao;

import java.time.LocalDate;

public record LotacaoPreview(
        Long lotId,
        LocalDate lotDataLotacao,
        LocalDate lotDataRemocao,
        String lotPortaria,
        String nomePessoa,
        String unidadeNome
) {
}
