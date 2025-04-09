package br.com.diegosilva.seletivo.infrastructure.unidade.models;

import br.com.diegosilva.seletivo.application.UpdateEnderecoCommand;
import br.com.diegosilva.seletivo.application.unidade.UpdateUnidadeUseCase;

import java.util.List;

public record UpdateUnidadeRequest(
        Long unidadeId,
        String nome,
        String sigla,
        List<UpdateEnderecoCommand> enderecos
) implements UpdateUnidadeUseCase.Input {
}
