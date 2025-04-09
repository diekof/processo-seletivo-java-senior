package br.com.diegosilva.seletivo.infrastructure.unidade.models;

import br.com.diegosilva.seletivo.application.unidade.UpdateUnidadeUseCase;

public record UpdateUnidadeResponse(Long unidadeId) {

    public UpdateUnidadeResponse(UpdateUnidadeUseCase.Output out) {
        this(out.unidadeId().value());
    }
}
