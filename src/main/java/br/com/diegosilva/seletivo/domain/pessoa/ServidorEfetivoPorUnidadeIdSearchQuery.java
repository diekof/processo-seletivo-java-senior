package br.com.diegosilva.seletivo.domain.pessoa;

import br.com.diegosilva.seletivo.domain.unidade.UnidadeId;

public record ServidorEfetivoPorUnidadeIdSearchQuery(
        int page,
        int perPage,
        UnidadeId unidId
) {
}
