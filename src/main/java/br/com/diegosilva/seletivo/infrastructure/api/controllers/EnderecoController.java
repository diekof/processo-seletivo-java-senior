package br.com.diegosilva.seletivo.infrastructure.api.controllers;

import br.com.diegosilva.seletivo.application.endereco.*;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoPreview;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoSearchQuery;
import br.com.diegosilva.seletivo.domain.exceptions.DomainException;
import br.com.diegosilva.seletivo.infrastructure.api.EnderecoAPI;
import br.com.diegosilva.seletivo.infrastructure.endereco.models.*;
import br.com.diegosilva.seletivo.infrastructure.endereco.presenters.EnderecoApiPresenter;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.Objects;


public class EnderecoController implements EnderecoAPI {

    private final CreateEnderecoUseCase createEnderecoUseCase;
    private final UpdateEnderecoUseCase updateEnderecoUseCase;
    private final BuscarEnderecoPorIdUseCase buscarEnderecoPorIdUseCase;
    private final BuscarEnderecoPaginadoUseCase buscarEnderecoPaginadoUseCase;
    private final DeleteEnderecoUseCase deleteEnderecoUseCase;

    public EnderecoController(CreateEnderecoUseCase createEnderecoUseCase,
                              UpdateEnderecoUseCase updateEnderecoUseCase,
                              BuscarEnderecoPorIdUseCase buscarEnderecoPorIdUseCase,
                              BuscarEnderecoPaginadoUseCase buscarEnderecoPaginadoUseCase, DeleteEnderecoUseCase deleteEnderecoUseCase) {
        this.createEnderecoUseCase = createEnderecoUseCase;
        this.updateEnderecoUseCase = updateEnderecoUseCase;
        this.buscarEnderecoPorIdUseCase = buscarEnderecoPorIdUseCase;
        this.buscarEnderecoPaginadoUseCase = buscarEnderecoPaginadoUseCase;
        this.deleteEnderecoUseCase = deleteEnderecoUseCase;
    }

    public ResponseEntity<CreateEnderecoResponse> create(CreateEnderecoUseCase.Input input) {
        final var res = createEnderecoUseCase.execute(input, CreateEnderecoResponse::new);
        return ResponseEntity.created(URI.create("/enderecos/"+res.enderecoId()))
                .body(res);
    }

    @Override
    public ResponseEntity<?> create(CreateEnderecoRequest input) {
        return null;
    }

    @Override
    public ResponseEntity<UpdateEnderecoResponse> updateById(Long id, UpdateEnderecoRequest req) {
        if (!Objects.equals(req.enderecoId(), id)) {
            throw DomainException.with("Endereço identifier doesn't matches");
        }

        return ResponseEntity.ok().body(updateEnderecoUseCase.execute(req, UpdateEnderecoResponse::new));
    }

    @Override
    public EnderecoResponse getById(Long id) {
        final var aInput = new BuscarEnderecoPorIdUseCase.Input(){
            @Override
            public Long enderecoId() {
                return id;
            }
        };
        return EnderecoApiPresenter.present(this.buscarEnderecoPorIdUseCase.execute(aInput));
    }

    @Override
    public Pagination<EnderecoPreview> list(int page, int perPage, String endTipoLogradouro, String endLogradouro, Integer endNumero, String endBairro, Long cidadeId) {
        final var aCidadeId = cidadeId != null ? new CidadeId(cidadeId) : CidadeId.empty();
        final var parm = new EnderecoSearchQuery(page,perPage,endTipoLogradouro,  endLogradouro,  endNumero,  endBairro, aCidadeId);
        return buscarEnderecoPaginadoUseCase.execute(parm);
    }

    @Override
    public void deleteById(Long id) {
        this.deleteEnderecoUseCase.execute(id);
    }
}
