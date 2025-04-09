package br.com.diegosilva.seletivo.application.endereco;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.cidade.Cidade;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoID;

public abstract class BuscarEnderecoPorIdUseCase extends UseCase<BuscarEnderecoPorIdUseCase.Input,BuscarEnderecoPorIdUseCase.Output> {

    public interface Input{
        Long enderecoId();
    }

    public interface Output{
        EnderecoID enderecoId();
        String endTipoLogradouro();
        String endLogradouro();
        Integer endNumero();
        String endBairro();
        Cidade cidade();
    }
}
