package br.com.diegosilva.seletivo.application.unidade.impl;

import br.com.diegosilva.seletivo.application.unidade.BuscarUnidadePaginadoUseCase;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeGateway;
import br.com.diegosilva.seletivo.domain.unidade.UnidadePreview;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeSearchQuery;

public class DefaultBuscarUnidadePaginadoUseCase extends BuscarUnidadePaginadoUseCase {
    private final UnidadeGateway unidadeGateway;

    public DefaultBuscarUnidadePaginadoUseCase(UnidadeGateway unidadeGateway) {
        this.unidadeGateway = unidadeGateway;
    }


    @Override
    public Pagination<UnidadePreview> execute(UnidadeSearchQuery unidadeSearchQuery) {
        return this.unidadeGateway.findAll(unidadeSearchQuery);
    }
}
