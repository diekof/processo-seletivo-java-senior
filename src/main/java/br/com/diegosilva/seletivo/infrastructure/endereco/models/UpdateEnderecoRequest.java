package br.com.diegosilva.seletivo.infrastructure.endereco.models;

import br.com.diegosilva.seletivo.application.endereco.UpdateEnderecoUseCase;

public record UpdateEnderecoRequest(
        Long enderecoId,
        String endTipoLogradouro,
        String endLogradouro,
        Integer endNumero,
        String endBairro,
        Long cidadeId
) implements UpdateEnderecoUseCase.Input {
}
