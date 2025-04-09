package br.com.diegosilva.seletivo.domain.endereco;

import br.com.diegosilva.seletivo.domain.Pagination;

import java.util.List;
import java.util.Optional;

public interface EnderecoGateway {
    EnderecoID nextId();
    Endereco save(Endereco endereco);
    void delete(EnderecoID endId);
    Optional<Endereco> enderecoOfId(final EnderecoID anId);
    Pagination<EnderecoPreview> findAll(EnderecoSearchQuery search);
    List<EnderecoID> existsByIds(Iterable<EnderecoID> ids);
}
