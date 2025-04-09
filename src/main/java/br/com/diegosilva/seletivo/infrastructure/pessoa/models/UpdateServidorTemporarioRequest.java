package br.com.diegosilva.seletivo.infrastructure.pessoa.models;

import br.com.diegosilva.seletivo.application.UpdateEnderecoCommand;
import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.UpdateServidorTemporarioUseCase;

import java.time.LocalDate;
import java.util.List;

public record UpdateServidorTemporarioRequest(
        Long pesId,
        String pesNome,
        LocalDate pesDataNascimento,
        String pesSexo,
        String pesMae,
        String pesPai,
        List<UpdateEnderecoCommand> enderecos,
        LocalDate stDataDemissao,
        LocalDate stDataAdmissao
) implements UpdateServidorTemporarioUseCase.Input {
}
