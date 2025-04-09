package br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.impl;

import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.UpdateServidorTemporarioUseCase;
import br.com.diegosilva.seletivo.domain.Identifier;
import br.com.diegosilva.seletivo.domain.cidade.Cidade;
import br.com.diegosilva.seletivo.domain.cidade.CidadeGateway;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;
import br.com.diegosilva.seletivo.domain.endereco.Endereco;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoGateway;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoID;
import br.com.diegosilva.seletivo.domain.exceptions.DomainException;
import br.com.diegosilva.seletivo.domain.exceptions.NotFoundException;
import br.com.diegosilva.seletivo.domain.pessoa.Pessoa;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaGateway;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaId;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultUpdateServidorTemporarioUseCase extends UpdateServidorTemporarioUseCase {

    private final PessoaGateway pessoaGateway;
    private final EnderecoGateway enderecoGateway;
    private final CidadeGateway cidadeGateway;

    public DefaultUpdateServidorTemporarioUseCase(PessoaGateway pessoaGateway, EnderecoGateway enderecoGateway, CidadeGateway cidadeGateway) {
        this.pessoaGateway = pessoaGateway;
        this.enderecoGateway = enderecoGateway;
        this.cidadeGateway = cidadeGateway;
    }

    @Override
    public Output execute(Input input) {
        final Pessoa aPessoa = this.pessoaGateway.pessoaOfId(new PessoaId(input.pesId()))
                .orElseThrow(() -> NotFoundException.with("Pessoa com id %s não pode ser encontrado".formatted(input.pesId())));

        if(aPessoa.getServidorTemporario() == null){
            throw DomainException.with("Pessoa não é um servidor temporário");
        }


        List<Endereco> enderecos= input.enderecos().stream().map(er -> {
            Cidade cidade = cidadeGateway.cidadeOfId(new CidadeId(er.cidadeId()))
                    .orElseThrow(() -> DomainException.with("Cidade com id %s não pode ser encontrado".formatted(er.cidadeId())));

            EnderecoID endId = er.endId() != null ? new EnderecoID(er.endId()) : EnderecoID.empty();

            return new Endereco(
                    endId,
                    er.endTipoLogradouro(),
                    er.endLogradouro(),
                    er.endNumero(),
                    er.endBairro(),
                    cidade);

        }).collect(Collectors.toList());

        aPessoa.getServidorTemporario().updateDataDemissaoEadmissao(input.stDataDemissao(),input.stDataAdmissao());

        aPessoa.updatePesMae(input.pesMae());
        aPessoa.updatePesDataNascimento(input.pesDataNascimento());
        aPessoa.updatePesSexo(input.pesSexo());
        aPessoa.updatePesPai(input.pesPai());
        aPessoa.updatePesNome(input.pesNome());
        aPessoa.updateEnderecos(enderecos);
        var  pessoaBD = pessoaGateway.save(aPessoa);
        return new StdOutput(pessoaBD.id());
    }

    record StdOutput(PessoaId pesId) implements Output {}

    private void validateEnderecos(final Set<EnderecoID> ids){
        if (ids == null || ids.isEmpty()) {
            return ;
        }

        final var retrievedIds = enderecoGateway.existsByIds(ids);

        if (ids.size() != retrievedIds.size()) {
            final var missingIds = new ArrayList<>(ids);
            missingIds.removeAll(retrievedIds);

            final var missingIdsMessage = missingIds.stream()
                    .map(Identifier::value)
                    .map(id ->id.toString())
                    .collect(Collectors.joining(", "));

            throw DomainException.with("Alguns Endereços não pode ser encontrado: %s".formatted(missingIdsMessage) );
        }
    }
}
