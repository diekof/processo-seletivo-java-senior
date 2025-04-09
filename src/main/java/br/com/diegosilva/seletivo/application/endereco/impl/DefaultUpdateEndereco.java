package br.com.diegosilva.seletivo.application.endereco.impl;

import br.com.diegosilva.seletivo.application.endereco.UpdateEnderecoUseCase;
import br.com.diegosilva.seletivo.domain.cidade.CidadeGateway;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;
import br.com.diegosilva.seletivo.domain.endereco.Endereco;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoGateway;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoID;
import br.com.diegosilva.seletivo.domain.exceptions.NotFoundException;

public class DefaultUpdateEndereco extends UpdateEnderecoUseCase {
    private final EnderecoGateway enderecoGateway;
    private final CidadeGateway cidadeGateway;

    public DefaultUpdateEndereco(EnderecoGateway enderecoGateway,
                                 CidadeGateway cidadeGateway) {
        this.enderecoGateway = enderecoGateway;
        this.cidadeGateway = cidadeGateway;
    }

    @Override
    public Output execute(Input input) {

        final var aEndereco = this.enderecoGateway.enderecoOfId(new EnderecoID(input.enderecoId()))
                .orElseThrow(() -> NotFoundException.with("Endereco com id %s não pode ser encontrado".formatted(input.enderecoId())));

        final var aCidade = this.cidadeGateway.cidadeOfId(new CidadeId(input.cidadeId()))
                .orElseThrow(() -> NotFoundException.with("Cidade com id %s não pode ser encontrado".formatted(input.cidadeId())));

        aEndereco.updateEndBairro(input.endBairro());
        aEndereco.updateEndNumero(input.endNumero());
        aEndereco.updateEndLogradouro(input.endLogradouro());
        aEndereco.updateEndTipoLogradouro(input.endTipoLogradouro());
        aEndereco.updateCidade(aCidade);

        return new StdOutput(enderecoGateway.save(aEndereco));
    }

    record StdOutput(EnderecoID enderecoId) implements Output {

        public StdOutput(Endereco end){
             this(end.id());
        }
    }
}
