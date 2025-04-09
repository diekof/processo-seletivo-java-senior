package br.com.diegosilva.seletivo.application.lotacao.impl;

import br.com.diegosilva.seletivo.application.lotacao.DeleteLotacaoUseCase;
import br.com.diegosilva.seletivo.domain.lotacao.LotacaoGateway;
import br.com.diegosilva.seletivo.domain.lotacao.LotacaoId;

public class DefaultDeleteLotacaoUseCase extends DeleteLotacaoUseCase {

    private final LotacaoGateway lotacaoGateway;

    public DefaultDeleteLotacaoUseCase(LotacaoGateway lotacaoGateway) {
        this.lotacaoGateway = lotacaoGateway;
    }

    @Override
    public void execute(Long anIn) {
        this.lotacaoGateway.delete(new LotacaoId(anIn));
    }
}
