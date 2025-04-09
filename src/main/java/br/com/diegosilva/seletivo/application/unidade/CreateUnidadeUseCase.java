package br.com.diegosilva.seletivo.application.unidade;

import br.com.diegosilva.seletivo.application.CreateEnderecoCommand;
import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeId;

import java.util.List;

public abstract class CreateUnidadeUseCase extends UseCase<CreateUnidadeUseCase.Input,CreateUnidadeUseCase.Output> {

    public interface Input{
         String nome();
         String sigla();
        List<CreateEnderecoCommand> enderecos();
    }

    public interface Output{
        UnidadeId unidadeId();
    }
}
