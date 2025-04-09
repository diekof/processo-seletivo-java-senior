package br.com.diegosilva.seletivo.application.cidade.impl;

import br.com.diegosilva.seletivo.application.cidade.BuscaCidadePaginadoUseCase;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.cidade.CidadeGateway;
import br.com.diegosilva.seletivo.domain.cidade.CidadePreview;
import br.com.diegosilva.seletivo.domain.cidade.CidadeSearchQuery;

public class DefaultBuscaCidadePaginadoUseCase extends BuscaCidadePaginadoUseCase {

    private final CidadeGateway cidadeGateway;

    public DefaultBuscaCidadePaginadoUseCase(CidadeGateway cidadeGateway) {
        this.cidadeGateway = cidadeGateway;
    }

    @Override
    public Pagination<CidadePreview> execute(CidadeSearchQuery input) {
        return this.cidadeGateway.findAll(input);
    }


}
