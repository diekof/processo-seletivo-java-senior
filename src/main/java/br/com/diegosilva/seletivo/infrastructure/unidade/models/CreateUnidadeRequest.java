package br.com.diegosilva.seletivo.infrastructure.unidade.models;

import br.com.diegosilva.seletivo.application.CreateEnderecoCommand;
import br.com.diegosilva.seletivo.application.unidade.CreateUnidadeUseCase;

import java.util.List;

public record CreateUnidadeRequest(
        String nome,
        String sigla,
        List<CreateEnderecoCommand> enderecos
) implements CreateUnidadeUseCase.Input {
}
