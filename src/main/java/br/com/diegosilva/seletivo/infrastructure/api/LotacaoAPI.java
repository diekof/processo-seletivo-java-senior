package br.com.diegosilva.seletivo.infrastructure.api;

import br.com.diegosilva.seletivo.infrastructure.lotacao.models.CreateLotacaoRequest;
import br.com.diegosilva.seletivo.infrastructure.lotacao.models.LotacaoResponse;
import br.com.diegosilva.seletivo.infrastructure.lotacao.models.UpdateLotacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "lotacao")
@Tag(name = "Lotação")
public interface LotacaoAPI {
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Criar nova Lotação para um servidor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<?> createLotacao(@RequestBody CreateLotacaoRequest input);

    @PutMapping(
            value = "{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Atualizar uma lotação pelo identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lotação updated successfully"),
            @ApiResponse(responseCode = "404", description = "Lotação was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    ResponseEntity<?> updateById(@PathVariable(name = "id") Long id, @RequestBody UpdateLotacaoRequest input);


    @GetMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Buscar uma Lotação por identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lotação retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Lotação was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    LotacaoResponse getById(@PathVariable(name = "id") Long id);


    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar um lotação pelo identificador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "lotação deletado"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    })
    void deleteById(@PathVariable(name = "id") Long id);
}
