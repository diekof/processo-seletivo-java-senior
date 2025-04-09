package br.com.diegosilva.seletivo.domain.unidade;

public record UnidadeSearchQuery(
        int page,
        int perPage,
        String nome,
        String sigla
) {
}
