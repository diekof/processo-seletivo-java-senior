package br.com.diegosilva.seletivo.infrastructure.pessoa.models;

import br.com.diegosilva.seletivo.application.UpdateEnderecoCommand;
import br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.UpdateServidorEfetivoUseCase;

import java.time.LocalDate;
import java.util.List;

public record UpdateServidorEfetivoRequest(
        Long pesId,
        String pesNome,
        LocalDate pesDataNascimento,
        String pesSexo,
        String pesMae,
        String pesPai,
        String matricula,
        List<UpdateEnderecoCommand> enderecos

) implements UpdateServidorEfetivoUseCase.Input {
}
