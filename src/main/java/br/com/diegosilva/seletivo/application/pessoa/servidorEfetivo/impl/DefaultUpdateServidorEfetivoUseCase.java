package br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.impl;

import br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.UpdateServidorEfetivoUseCase;
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

public class DefaultUpdateServidorEfetivoUseCase extends UpdateServidorEfetivoUseCase {
    private final PessoaGateway pessoaGateway;
    private final EnderecoGateway enderecoGateway;
    private final CidadeGateway cidadeGateway;

    public DefaultUpdateServidorEfetivoUseCase(PessoaGateway pessoaGateway, EnderecoGateway enderecoGateway, CidadeGateway cidadeGateway) {
        this.pessoaGateway = pessoaGateway;
        this.enderecoGateway = enderecoGateway;
        this.cidadeGateway = cidadeGateway;
    }

    @Override
    public Output execute(Input input) {

        final Pessoa aPessoa = this.pessoaGateway.pessoaOfId(new PessoaId(input.pesId()))
                .orElseThrow(() -> NotFoundException.with("Pessoa com id %s não pode ser encontrado".formatted(input.pesId())));

        if(aPessoa.getServidorEfetivo() == null){
            throw DomainException.with("Pessoa não é um servidor efetivo");
        }

//        Set<Endereco> enderecos= input.enderecos();
//
//        if(enderecos != null){
//            var cidade = enderecos.stream().map(e -> e.getCidade().id()).collect(Collectors.toSet());
//            validateCidade(cidade);
//        }

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

        aPessoa.getServidorEfetivo().updateMatricula(input.matricula());
        aPessoa.updatePesMae(input.pesMae());
        aPessoa.updatePesDataNascimento(input.pesDataNascimento());
        aPessoa.updatePesSexo(input.pesSexo());
        aPessoa.updatePesPai(input.pesPai());
        aPessoa.updatePesNome(input.pesNome());
        aPessoa.updateEnderecos(enderecos);
        var  pessoaBD = pessoaGateway.save(aPessoa);
        return new StdOutput(pessoaBD.id());
    }

    record StdOutput(PessoaId pesId) implements UpdateServidorEfetivoUseCase.Output {}

    private void validateCidade(final Set<CidadeId> ids){
        if (ids == null || ids.isEmpty()) {
            return ;
        }

        final var retrievedIds = cidadeGateway.existsByIds(ids);

        if (ids.size() != retrievedIds.size()) {
            final var missingIds = new ArrayList<>(ids);
            missingIds.removeAll(retrievedIds);

            final var missingIdsMessage = missingIds.stream()
                    .map(Identifier::value)
                    .map(id ->id.toString())
                    .collect(Collectors.joining(", "));

            throw DomainException.with("Algumas cidades não pode ser encontrado: %s".formatted(missingIdsMessage) );
        }
    }
}
