package br.com.diegosilva.seletivo.application.cidade.impl;

import br.com.diegosilva.seletivo.application.cidade.UpdateCidadeUseCase;
import br.com.diegosilva.seletivo.domain.cidade.CidadeGateway;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;
import br.com.diegosilva.seletivo.domain.exceptions.NotFoundException;

public class DefaultUpdateCidade extends UpdateCidadeUseCase {

    private final CidadeGateway cidadeGateway;

    public DefaultUpdateCidade(CidadeGateway cidadeGateway) {
        this.cidadeGateway = cidadeGateway;
    }

    @Override
    public Output execute(Input input) {
        final var aCidade = this.cidadeGateway.cidadeOfId(new CidadeId(input.cidadeId()))
                .orElseThrow(() -> NotFoundException.with("Cidade com id %s não pode ser encontrado".formatted(input.cidadeId())));

        aCidade.setUf(input.uf());
        aCidade.setNome(input.nome());
        this.cidadeGateway.save(aCidade);

        return new StdOutput(aCidade.id());
    }

    record StdOutput(CidadeId cidadeId) implements Output{}
}
