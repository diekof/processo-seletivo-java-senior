package br.com.diegosilva.seletivo.application.endereco.impl;

import br.com.diegosilva.seletivo.application.endereco.BuscarEnderecoPorIdUseCase;
import br.com.diegosilva.seletivo.domain.cidade.Cidade;
import br.com.diegosilva.seletivo.domain.endereco.Endereco;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoGateway;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoID;
import br.com.diegosilva.seletivo.domain.exceptions.NotFoundException;

public class DefaultiBuscarEnderecoPorIdUseCase extends BuscarEnderecoPorIdUseCase {

    private final EnderecoGateway enderecoGateway;


    public DefaultiBuscarEnderecoPorIdUseCase(EnderecoGateway enderecoGateway) {
        this.enderecoGateway = enderecoGateway;
    }

    @Override
    public Output execute(Input input) {

        final var enderecoId = new EnderecoID((input.enderecoId()));
        return this.enderecoGateway
                .enderecoOfId(enderecoId)
                .map(StdOutput::new)
                .orElseThrow(()-> NotFoundException.with("Endereço não encontrado"));
       
    }

    record StdOutput(
        EnderecoID enderecoId,
        String endTipoLogradouro,
        String endLogradouro,
        Integer endNumero,
        String endBairro,
        Cidade cidade
    ) implements Output{

        public StdOutput(Endereco end){
            this(
                    end.id(),
                    end.getEndTipoLogradouro(),
                    end.getEndLogradouro(),
                    end.getEndNumero(),
                    end.getEndBairro(),
                    end.getCidade()
            );
        }
    }
}
