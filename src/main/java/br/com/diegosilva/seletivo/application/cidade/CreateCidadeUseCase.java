package br.com.diegosilva.seletivo.application.cidade;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;

public abstract class CreateCidadeUseCase extends UseCase<CreateCidadeUseCase.Input, CreateCidadeUseCase.Output> {

    public interface Input{
        String nome();
        String uf();
    }
    public interface Output{
        CidadeId cidadeId();
    }
}
