package br.com.diegosilva.seletivo.application.pessoa.servidorTemporario;

import br.com.diegosilva.seletivo.application.CreateEnderecoCommand;
import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaId;

import java.time.LocalDate;
import java.util.List;

public abstract class CreateServidorTemporarioUseCase extends UseCase<CreateServidorTemporarioUseCase.Input,CreateServidorTemporarioUseCase.Output> {
    public interface Input{
        String pesNome();
        LocalDate pesDataNascimento();
        String pesSexo();
        String pesMae();
        String pesPai();
        List<CreateEnderecoCommand> enderecos();
        LocalDate stDataDemissao();
        LocalDate stDataAdmissao();
    }

    public interface Output{
        PessoaId pesId();
    }


}
