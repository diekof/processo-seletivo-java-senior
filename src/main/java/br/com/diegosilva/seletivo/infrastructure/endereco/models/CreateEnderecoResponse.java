package br.com.diegosilva.seletivo.infrastructure.endereco.models;


import br.com.diegosilva.seletivo.application.endereco.CreateEnderecoUseCase;

public record CreateEnderecoResponse(Long enderecoId) {

    public CreateEnderecoResponse(CreateEnderecoUseCase.Output out){
        this(out.enderecoId().value());
    }
}
