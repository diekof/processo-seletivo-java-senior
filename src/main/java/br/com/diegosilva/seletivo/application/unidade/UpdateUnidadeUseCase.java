package br.com.diegosilva.seletivo.application.unidade;

import br.com.diegosilva.seletivo.application.UpdateEnderecoCommand;
import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeId;

import java.util.List;

public abstract class UpdateUnidadeUseCase extends UseCase<UpdateUnidadeUseCase.Input,UpdateUnidadeUseCase.Output> {

    public interface Input{
        Long unidadeId();
        String nome();
        String sigla();
        List<UpdateEnderecoCommand> enderecos();
    }

    public interface Output{
        UnidadeId unidadeId();
    }
}
