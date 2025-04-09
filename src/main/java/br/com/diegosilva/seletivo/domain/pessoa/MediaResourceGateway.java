package br.com.diegosilva.seletivo.domain.pessoa;

import br.com.diegosilva.seletivo.domain.shared.Resource;

public interface MediaResourceGateway {
    PessoaFoto storeImage(PessoaId anId, Resource aResource);
    String generateTemporaryLink(String id);

    void clearResources(PessoaId pessoaId);
}
