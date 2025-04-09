package br.com.diegosilva.seletivo.infrastructure.lotacao.models;

import br.com.diegosilva.seletivo.application.lotacao.CreateLotacaoUseCase;

public record CreateLotacaoResponse(
        Long lotId
) {
    public CreateLotacaoResponse(CreateLotacaoUseCase.Output out){
        this(out.lotId().value());
    }
}
