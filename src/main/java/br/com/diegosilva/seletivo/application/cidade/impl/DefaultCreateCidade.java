package br.com.diegosilva.seletivo.application.cidade.impl;

import br.com.diegosilva.seletivo.application.cidade.CreateCidadeUseCase;
import br.com.diegosilva.seletivo.domain.cidade.Cidade;
import br.com.diegosilva.seletivo.domain.cidade.CidadeGateway;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;

import java.util.Objects;

public class DefaultCreateCidade extends CreateCidadeUseCase {

    private final CidadeGateway cidadeGateway;

    public DefaultCreateCidade(CidadeGateway cidadeGateway) {
        this.cidadeGateway = Objects.requireNonNull(cidadeGateway);
    }

    @Override
    public CreateCidadeUseCase.Output execute(CreateCidadeUseCase.Input input) {
        final var aCidade = this.cidadeGateway.save(newCidadeWith(input));
        return new StdOutput(aCidade.id());
    }

    private Cidade newCidadeWith(final CreateCidadeUseCase.Input in){
        return new Cidade(
                this.cidadeGateway.nextId(),
                in.nome(),
                in.uf()
        );
    }
    record StdOutput(CidadeId cidadeId) implements CreateCidadeUseCase.Output {}
}
