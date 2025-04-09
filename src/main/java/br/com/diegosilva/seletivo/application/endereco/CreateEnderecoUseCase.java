package br.com.diegosilva.seletivo.application.endereco;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoID;

public abstract class CreateEnderecoUseCase extends UseCase<CreateEnderecoUseCase.Input,CreateEnderecoUseCase.Output> {

    public interface Input{
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
