package br.com.diegosilva.seletivo.infrastructure.pessoa.models;

import br.com.diegosilva.seletivo.application.CreateEnderecoCommand;
import br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.CreateServidorEfetivoUseCase;

import java.time.LocalDate;
import java.util.List;

public record CreateServidorEfetivoRequest(
        String pesNome,
        LocalDate pesDataNascimento,
        String pesSexo,
        String pesMae,
        String pesPai,
        List<CreateEnderecoCommand> enderecos,
        String matricula
) implements CreateServidorEfetivoUseCase.Input {


}


