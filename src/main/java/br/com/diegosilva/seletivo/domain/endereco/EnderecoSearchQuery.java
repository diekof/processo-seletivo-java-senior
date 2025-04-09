package br.com.diegosilva.seletivo.domain.endereco;

import br.com.diegosilva.seletivo.domain.cidade.CidadeId;

public record EnderecoSearchQuery(
        int page,
        int perPage,
        String endTipoLogradouro,
        String endLogradouro,
        Integer endNumero,
        String endBairro,
        CidadeId cidadeId
) {
}
