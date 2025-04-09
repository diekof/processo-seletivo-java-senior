package br.com.diegosilva.seletivo.domain.lotacao;

import br.com.diegosilva.seletivo.domain.unidade.UnidadeId;

public record LotacaoSearchQuery(
        int page,
        int perPage,
        String lotPortaria,
        UnidadeId unidadeId
) {
}
