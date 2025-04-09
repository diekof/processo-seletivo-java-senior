package br.com.diegosilva.seletivo.application.pessoa.servidorTemporario;

import br.com.diegosilva.seletivo.application.UpdateEnderecoCommand;
import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaId;

import java.time.LocalDate;
import java.util.List;

public abstract class UpdateServidorTemporarioUseCase extends UseCase<UpdateServidorTemporarioUseCase.Input,UpdateServidorTemporarioUseCase.Output> {

    public interface Input{
        Long pesId();
        String pesNome();
        LocalDate pesDataNascimento();
        String pesSexo();
        String pesMae();
        String pesPai();
        LocalDate stDataDemissao();
        LocalDate stDataAdmissao();
        List<UpdateEnderecoCommand> enderecos();
    }

    public interface Output{
        PessoaId pesId();
    }
}
