package br.com.diegosilva.seletivo.infrastructure.pessoa.models;

import br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.UpdateServidorEfetivoUseCase;

public record UpdateServidorEfetivoResponse(Long pesId) {
    public UpdateServidorEfetivoResponse(UpdateServidorEfetivoUseCase.Output out){
        this(out.pesId().value());
    }
}
