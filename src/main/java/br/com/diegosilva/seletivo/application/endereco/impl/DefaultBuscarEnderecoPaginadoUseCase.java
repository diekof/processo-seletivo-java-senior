package br.com.diegosilva.seletivo.application.endereco.impl;

import br.com.diegosilva.seletivo.application.endereco.BuscarEnderecoPaginadoUseCase;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoGateway;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoPreview;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoSearchQuery;

public class DefaultBuscarEnderecoPaginadoUseCase extends BuscarEnderecoPaginadoUseCase {

    private final EnderecoGateway enderecoGateway;

    public DefaultBuscarEnderecoPaginadoUseCase(EnderecoGateway enderecoGateway) {
        this.enderecoGateway = enderecoGateway;
    }

    @Override
    public Pagination<EnderecoPreview> execute(EnderecoSearchQuery enderecoSearchQuery) {
        return this.enderecoGateway.findAll(enderecoSearchQuery);
    }
}
