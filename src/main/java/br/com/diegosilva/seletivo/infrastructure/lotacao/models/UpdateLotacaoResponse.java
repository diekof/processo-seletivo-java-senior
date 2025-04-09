package br.com.diegosilva.seletivo.infrastructure.lotacao.models;

import br.com.diegosilva.seletivo.application.lotacao.UpdateLotacaoUseCase;

public record UpdateLotacaoResponse(Long lotId
) {
    public UpdateLotacaoResponse(UpdateLotacaoUseCase.Output out){
        this(out.lotId().value());
    }
}