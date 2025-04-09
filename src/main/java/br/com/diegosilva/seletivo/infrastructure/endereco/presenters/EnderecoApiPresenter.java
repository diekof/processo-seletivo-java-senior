package br.com.diegosilva.seletivo.infrastructure.endereco.presenters;

import br.com.diegosilva.seletivo.application.endereco.BuscarEnderecoPorIdUseCase;
import br.com.diegosilva.seletivo.infrastructure.cidade.models.CidadeResponse;
import br.com.diegosilva.seletivo.infrastructure.endereco.models.EnderecoResponse;

public interface EnderecoApiPresenter {
    static EnderecoResponse present(final BuscarEnderecoPorIdUseCase.Output out){
        return new EnderecoResponse(
                out.enderecoId().value(),
                out.endTipoLogradouro(),
                out.endLogradouro(),
                out.endNumero(),
                out.endBairro(),
                new CidadeResponse(
                    out.cidade().id().value(),
                    out.cidade().getNome(),
                    out.cidade().getUf()
                )

        );
    }
}
