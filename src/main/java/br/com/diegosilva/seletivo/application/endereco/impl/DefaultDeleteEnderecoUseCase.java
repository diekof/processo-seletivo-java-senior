package br.com.diegosilva.seletivo.application.endereco.impl;

import br.com.diegosilva.seletivo.application.endereco.DeleteEnderecoUseCase;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoGateway;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoID;

public class DefaultDeleteEnderecoUseCase extends DeleteEnderecoUseCase {
    private final EnderecoGateway enderecoGateway;

    public DefaultDeleteEnderecoUseCase(EnderecoGateway enderecoGateway) {
        this.enderecoGateway = enderecoGateway;
    }


    @Override
    public void execute(Long anIn) {
        final var enderecoId = new EnderecoID(anIn);
        enderecoGateway.delete(enderecoId);
    }
}
