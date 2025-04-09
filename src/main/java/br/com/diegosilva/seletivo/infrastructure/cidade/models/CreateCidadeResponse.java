package br.com.diegosilva.seletivo.infrastructure.cidade.models;

import br.com.diegosilva.seletivo.application.cidade.CreateCidadeUseCase;

public record CreateCidadeResponse(Long cidadeId) {

    public CreateCidadeResponse(CreateCidadeUseCase.Output out) {
        this(out.cidadeId().value());
    }
}
