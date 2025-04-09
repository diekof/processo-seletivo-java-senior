package br.com.diegosilva.seletivo.domain.lotacao;

import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaId;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeId;

import java.time.LocalDate;
import java.util.Optional;

public interface LotacaoGateway {
    LotacaoId nextId();
    Lotacao save(Lotacao pessoa);
    Optional<Lotacao> lotacaoOfId(final LotacaoId anId);
    Pagination<LotacaoPreview> findAll(LotacaoSearchQuery search);

    void delete(LotacaoId lotacaoId);

    Optional<Lotacao> existeLotacao(PessoaId pesId, UnidadeId unidId, LocalDate lotDataLotacao, LocalDate lotDataRemocao, String lotPortaria);
    Boolean existeLotacaoPorPesId(PessoaId pesId);
}
