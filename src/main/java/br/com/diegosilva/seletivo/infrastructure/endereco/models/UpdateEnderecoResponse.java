package br.com.diegosilva.seletivo.infrastructure.endereco.models;


import br.com.diegosilva.seletivo.application.endereco.UpdateEnderecoUseCase;

public record UpdateEnderecoResponse(Long enderecoId) {
    public UpdateEnderecoResponse(UpdateEnderecoUseCase.Output out){
        this(out.enderecoId().value());
    }
}
