package br.com.diegosilva.seletivo.infrastructure.pessoa.models;

import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.UpdateServidorTemporarioUseCase;

public record UpdateServidorTemporarioResponse(Long id) {

    public UpdateServidorTemporarioResponse(UpdateServidorTemporarioUseCase.Output out){
        this(out.pesId().value());
    }
}
