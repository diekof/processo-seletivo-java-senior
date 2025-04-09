package br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo;

import br.com.diegosilva.seletivo.application.CreateEnderecoCommand;
import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaId;

import java.time.LocalDate;
import java.util.List;

public abstract class CreateServidorEfetivoUseCase extends UseCase<CreateServidorEfetivoUseCase.Input,CreateServidorEfetivoUseCase.Output> {
    public interface Input{
         String pesNome();
         LocalDate pesDataNascimento();
         String pesSexo();
         String pesMae();
         String pesPai();
         String matricula();
        List<CreateEnderecoCommand> enderecos();
    }

    public interface Output{
        PessoaId pesId();
    }


}
