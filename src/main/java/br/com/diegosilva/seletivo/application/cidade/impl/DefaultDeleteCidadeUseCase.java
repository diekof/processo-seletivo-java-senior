package br.com.diegosilva.seletivo.application.cidade.impl;

import br.com.diegosilva.seletivo.application.cidade.DeleteCidadeUseCase;
import br.com.diegosilva.seletivo.domain.cidade.CidadeGateway;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;

public class DefaultDeleteCidadeUseCase extends DeleteCidadeUseCase {

    private final CidadeGateway cidadeGateway;

    public DefaultDeleteCidadeUseCase(CidadeGateway cidadeGateway) {
        this.cidadeGateway = cidadeGateway;
    }

    @Override
    public void execute(Long anIn) {
        final var cidadeId = new CidadeId(anIn);
        this.cidadeGateway.delete(cidadeId);
    }
}
