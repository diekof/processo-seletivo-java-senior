package br.com.diegosilva.seletivo.infrastructure.cidade.presenters;

import br.com.diegosilva.seletivo.application.cidade.BuscarCidadePorIdUseCase;
import br.com.diegosilva.seletivo.infrastructure.cidade.models.CidadeResponse;

public interface CidadeApiPresenter {
    static CidadeResponse present(final BuscarCidadePorIdUseCase.Output output){
        return new CidadeResponse(
                output.cidadeId().value(),
                output.nome(),
                output.uf()
        );
    }
}
