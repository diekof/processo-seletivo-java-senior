package br.com.diegosilva.seletivo.infrastructure.endereco.models;

import br.com.diegosilva.application.endereco.CreateEnderecoUseCase;

public record CreateEnderecoRequest(
        String endTipoLogradouro,
        String endLogradouro,
        Integer endNumero,
        String endBairro,
        Long cidadeId

) implements CreateEnderecoUseCase.Input {
}
