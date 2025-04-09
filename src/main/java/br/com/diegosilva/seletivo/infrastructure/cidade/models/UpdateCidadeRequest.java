package br.com.diegosilva.seletivo.infrastructure.cidade.models;

import br.com.diegosilva.seletivo.application.cidade.UpdateCidadeUseCase;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateCidadeRequest(
        @JsonProperty("cidadeId") Long cidadeId,
        @JsonProperty("nome") String nome,
        @JsonProperty("uf") String uf
) implements UpdateCidadeUseCase.Input {
}
