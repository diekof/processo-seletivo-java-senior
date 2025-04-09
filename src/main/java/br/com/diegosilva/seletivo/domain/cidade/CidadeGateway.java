package br.com.diegosilva.seletivo.domain.cidade;

import br.com.diegosilva.seletivo.domain.Pagination;

import java.util.List;
import java.util.Optional;

public interface CidadeGateway {
    CidadeId nextId();
    Cidade save(Cidade cidade);
    Optional<Cidade> cidadeOfId(final CidadeId anId);
    Pagination<CidadePreview> findAll(CidadeSearchQuery search);
    List<CidadeId> existsByIds(Iterable<CidadeId> ids);
    void delete(CidadeId cidadeId);
}
