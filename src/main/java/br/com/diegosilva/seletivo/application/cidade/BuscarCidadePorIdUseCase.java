package br.com.diegosilva.seletivo.application.cidade;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;

public abstract class BuscarCidadePorIdUseCase extends UseCase<BuscarCidadePorIdUseCase.Input,BuscarCidadePorIdUseCase.Output> {

    public interface Input{
        Long cidadeId();
    }

    public interface  Output{
        CidadeId cidadeId();
        String nome();
        String uf();
    }
}
