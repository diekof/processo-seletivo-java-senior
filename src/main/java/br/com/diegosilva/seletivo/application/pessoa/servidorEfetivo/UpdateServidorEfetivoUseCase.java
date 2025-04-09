package br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo;

import br.com.diegosilva.seletivo.application.UpdateEnderecoCommand;
import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaId;

import java.time.LocalDate;
import java.util.List;

public abstract class UpdateServidorEfetivoUseCase extends UseCase<UpdateServidorEfetivoUseCase.Input,UpdateServidorEfetivoUseCase.Output> {
    public interface Input{
        Long pesId();
        String pesNome();
        LocalDate pesDataNascimento();
        String pesSexo();
        String pesMae();
        String pesPai();
        String matricula();
        List<UpdateEnderecoCommand> enderecos();
    }

    public interface Output{
        PessoaId pesId();
    }


}
