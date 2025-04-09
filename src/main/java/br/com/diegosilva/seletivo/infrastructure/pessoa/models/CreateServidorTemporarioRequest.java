package br.com.diegosilva.seletivo.infrastructure.pessoa.models;

import br.com.diegosilva.seletivo.application.CreateEnderecoCommand;
import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.CreateServidorTemporarioUseCase;

import java.time.LocalDate;
import java.util.List;

public record CreateServidorTemporarioRequest(
        String pesNome,
        LocalDate pesDataNascimento,
        String pesSexo,
        String pesMae,
        String pesPai,
        List<CreateEnderecoCommand> enderecos,
        LocalDate stDataDemissao,
        LocalDate stDataAdmissao
) implements CreateServidorTemporarioUseCase.Input {
}
