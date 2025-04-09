package br.com.diegosilva.seletivo.infrastructure.pessoa.models;

import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.CreateServidorTemporarioUseCase;

public record CreateServidorTemporarioResponse(Long id) {

    public CreateServidorTemporarioResponse(CreateServidorTemporarioUseCase.Output out){
        this(out.pesId().value());
    }
}
