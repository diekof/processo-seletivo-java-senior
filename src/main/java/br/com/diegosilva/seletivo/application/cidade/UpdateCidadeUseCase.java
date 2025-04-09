package br.com.diegosilva.seletivo.application.cidade;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;

public abstract class UpdateCidadeUseCase extends UseCase<UpdateCidadeUseCase.Input, UpdateCidadeUseCase.Output> {

    public interface Input{
        Long cidadeId();
        String nome();
        String uf();
    }

    public interface Output{
        CidadeId cidadeId();
    }
}
