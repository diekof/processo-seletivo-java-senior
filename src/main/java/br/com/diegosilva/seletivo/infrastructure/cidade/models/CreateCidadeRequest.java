package br.com.diegosilva.seletivo.infrastructure.cidade.models;

import br.com.diegosilva.seletivo.application.cidade.CreateCidadeUseCase;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateCidadeRequest(
        @JsonProperty("nome") String nome,
        @JsonProperty("uf") String uf
) implements CreateCidadeUseCase.Input{
}
