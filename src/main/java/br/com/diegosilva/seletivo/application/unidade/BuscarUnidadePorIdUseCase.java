package br.com.diegosilva.seletivo.application.unidade;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.endereco.Endereco;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeId;

import java.util.List;

public abstract class BuscarUnidadePorIdUseCase extends UseCase<BuscarUnidadePorIdUseCase.Input,BuscarUnidadePorIdUseCase.Output> {

    public interface Input{
        Long unidadeId();
    }

    public interface Output{
        UnidadeId unidadeId();
        String nome();
        String sigla();
        List<Endereco> endereco();
    }
}
