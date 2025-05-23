package br.com.diegosilva.seletivo.application.lotacao.impl;

import br.com.diegosilva.seletivo.application.lotacao.UpdateLotacaoUseCase;
import br.com.diegosilva.seletivo.domain.exceptions.DomainException;
import br.com.diegosilva.seletivo.domain.exceptions.NotFoundException;
import br.com.diegosilva.seletivo.domain.lotacao.Lotacao;
import br.com.diegosilva.seletivo.domain.lotacao.LotacaoGateway;
import br.com.diegosilva.seletivo.domain.lotacao.LotacaoId;
import br.com.diegosilva.seletivo.domain.pessoa.Pessoa;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaGateway;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaId;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeGateway;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeId;

import java.util.Optional;

public class DefaultUpdateLotacaoUseCase extends UpdateLotacaoUseCase {
    private final LotacaoGateway lotacaoGateway;
    private final PessoaGateway pessoaGateway;
    private final UnidadeGateway unidadeGateway;

    public DefaultUpdateLotacaoUseCase(
            LotacaoGateway lotacaoGateway,
            PessoaGateway pessoaGateway,
            UnidadeGateway unidadeGateway) {
        this.lotacaoGateway = lotacaoGateway;
        this.pessoaGateway = pessoaGateway;
        this.unidadeGateway = unidadeGateway;
    }

    @Override
    public Output execute(Input input) {

        final Optional<Lotacao> opLotacao= lotacaoGateway.existeLotacao(
                new PessoaId( input.pesId()),
                new UnidadeId(input.unidId()),
                input.lotDataLotacao(),
                input.lotDataRemocao(),
                input.lotPortaria()
        );

        if(opLotacao.isPresent()){
            if (!opLotacao.get().id().equals(new LotacaoId(input.lotId()))){
                throw  DomainException.with("Já existe uma lotação com os mesmos dados");
            }

        }


        final Lotacao aLotacao = this.lotacaoGateway.lotacaoOfId(new LotacaoId(input.lotId()))
                .orElseThrow(() -> NotFoundException.with("Locatação com id %s não pode ser encontrado".formatted(input.lotId())));

        final var aUnidade = this.unidadeGateway.unidadeOfId(new UnidadeId(input.unidId()))
                .orElseThrow(() -> DomainException.with("Unidade com id %s não pode ser encontrado".formatted(input.unidId())));

        final Pessoa aPessoa = this.pessoaGateway.pessoaOfId(new PessoaId(input.pesId()))
                .orElseThrow(() -> DomainException.with("Pessoa com id %s não pode ser encontrado".formatted(input.pesId())));

        aLotacao.updateDataLotacaoERemocao(input.lotDataLotacao(),input.lotDataRemocao());
        aLotacao.updateLotPortaria(input.lotPortaria());
        aLotacao.updatePessoa(aPessoa);
        aLotacao.updateUnidade(aUnidade);

        final var lotacaoBD = lotacaoGateway.save(aLotacao);

        return  new StdOutput(lotacaoBD.id());
    }

    record StdOutput(LotacaoId lotId) implements UpdateLotacaoUseCase.Output {}
}
