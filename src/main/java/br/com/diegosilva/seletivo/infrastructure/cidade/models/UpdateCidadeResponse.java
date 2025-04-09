package br.com.diegosilva.seletivo.infrastructure.cidade.models;

import br.com.diegosilva.seletivo.application.cidade.UpdateCidadeUseCase;

public record UpdateCidadeResponse(Long cidadeId)  {

    public UpdateCidadeResponse(UpdateCidadeUseCase.Output out){
        this(out.cidadeId().value());
    }
}
