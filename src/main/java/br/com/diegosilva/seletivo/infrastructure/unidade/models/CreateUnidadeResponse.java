package br.com.diegosilva.seletivo.infrastructure.unidade.models;


import br.com.diegosilva.seletivo.application.unidade.CreateUnidadeUseCase;

public record CreateUnidadeResponse(Long unidadeId) {

    public CreateUnidadeResponse(CreateUnidadeUseCase.Output out) {
        this(out.unidadeId().value());
    }
}
