package br.com.diegosilva.seletivo.infrastructure.pessoa.models;

import br.com.diegosilva.seletivo.infrastructure.pessoa.persistence.PessoaJpaEntity;

public record ServidorEfetivoPorUnidadeIdCustom(
        PessoaJpaEntity pessoa,
        String unidadeLotacao
) {
}
