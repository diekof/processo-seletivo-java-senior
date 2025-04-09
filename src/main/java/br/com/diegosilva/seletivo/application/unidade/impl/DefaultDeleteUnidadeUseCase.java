package br.com.diegosilva.seletivo.application.unidade.impl;

import br.com.diegosilva.seletivo.application.unidade.DeleteUnidadeUseCase;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeGateway;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeId;

public class DefaultDeleteUnidadeUseCase extends DeleteUnidadeUseCase {
    private final UnidadeGateway unidadeGateway;

    public DefaultDeleteUnidadeUseCase(UnidadeGateway unidadeGateway) {
        this.unidadeGateway = unidadeGateway;
    }


    @Override
    public void execute(Long anIn) {
        this.unidadeGateway.delete(new UnidadeId(anIn));
    }
}
