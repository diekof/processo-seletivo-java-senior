package br.com.diegosilva.seletivo.domain.pessoa;

public record EnderecoFuncionalPorNomeServidorPreview(
        String endTipoLogradouro,
        String endLogradouro,
        Integer endNumero,
        String endBairro,
        String uf,
        String nomeCidade
) {
}
