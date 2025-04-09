package br.com.diegosilva.seletivo.application.endereco;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoID;

public abstract class UpdateEnderecoUseCase extends UseCase<UpdateEnderecoUseCase.Input, UpdateEnderecoUseCase.Output> {
    public interface Input{
        Long enderecoId();
        String endTipoLogradouro();
        String endLogradouro();
        Integer endNumero();
        String endBairro();
        Long cidadeId();
    }

    public interface Output{
        EnderecoID enderecoId();
    }
}
