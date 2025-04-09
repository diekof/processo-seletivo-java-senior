package br.com.diegosilva.seletivo.domain.cidade;

public record CidadeSearchQuery(
        int page,
        int perPage,
        String nome,
        String uf
) {
}
