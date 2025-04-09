package br.com.diegosilva.seletivo.application.cidade.impl;

import br.com.diegosilva.seletivo.application.cidade.BuscarCidadePorIdUseCase;
import br.com.diegosilva.seletivo.domain.cidade.Cidade;
import br.com.diegosilva.seletivo.domain.cidade.CidadeGateway;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;
import br.com.diegosilva.seletivo.domain.exceptions.NotFoundException;

public class DefaultBuscarCidadePorIdUseCase extends BuscarCidadePorIdUseCase {

    private final CidadeGateway cidadeGateway;

    public DefaultBuscarCidadePorIdUseCase(CidadeGateway cidadeGateway) {
        this.cidadeGateway = cidadeGateway;
    }

    @Override
    public Output execute(Input input) {
        final var aCidadeId = new CidadeId(input.cidadeId());
        return this.cidadeGateway
                .cidadeOfId(aCidadeId)
                .map(StdOut::new)
                .orElseThrow(()-> NotFoundException.with("Cidade não encontrado"));
    }

    record StdOut(
        CidadeId cidadeId,
        String nome,
        String uf
    ) implements Output{
        public StdOut(Cidade aCidade){
            this(aCidade.id(),aCidade.getNome(),aCidade.getUf());
        }
    }
}
