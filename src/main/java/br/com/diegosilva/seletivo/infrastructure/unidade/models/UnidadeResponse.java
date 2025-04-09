package br.com.diegosilva.seletivo.infrastructure.unidade.models;

import br.com.diegosilva.seletivo.infrastructure.endereco.models.EnderecoResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UnidadeResponse(
        @JsonProperty("unidadeId") Long unidadeId,
        @JsonProperty("nome") String nome,
        @JsonProperty("sigla") String sigla,
        @JsonProperty("enderecos") List<EnderecoResponse> enderecosId
) {
}
