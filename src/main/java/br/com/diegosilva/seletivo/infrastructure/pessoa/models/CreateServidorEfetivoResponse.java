package br.com.diegosilva.seletivo.infrastructure.pessoa.models;

import br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.CreateServidorEfetivoUseCase;

public record CreateServidorEfetivoResponse(Long id) {

    public CreateServidorEfetivoResponse(CreateServidorEfetivoUseCase.Output out){
        this(out.pesId().value());
    }
}

