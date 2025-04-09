package br.com.diegosilva.seletivo.infrastructure.config.usecases;

import br.com.diegosilva.seletivo.application.endereco.*;
import br.com.diegosilva.seletivo.application.endereco.impl.*;
import br.com.diegosilva.seletivo.domain.cidade.CidadeGateway;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnderecoUseCaseConfig {
    private final CidadeGateway cidadeGateway;
    private final EnderecoGateway enderecoGateway;


    public EnderecoUseCaseConfig(CidadeGateway cidadeGateway, EnderecoGateway enderecoGateway) {
        this.cidadeGateway = cidadeGateway;
        this.enderecoGateway = enderecoGateway;
    }

    @Bean
    public CreateEnderecoUseCase createEnderecoUseCase(){
        return new DefaultCreateEnderecoUseCase(enderecoGateway,cidadeGateway);
    }

    @Bean
    public UpdateEnderecoUseCase updateEnderecoUseCase(){
        return new DefaultUpdateEndereco(enderecoGateway,cidadeGateway);
    }

    @Bean
    public BuscarEnderecoPorIdUseCase buscarEnderecoPorIdUseCase(){
        return new DefaultiBuscarEnderecoPorIdUseCase(enderecoGateway);
    }

    @Bean
    BuscarEnderecoPaginadoUseCase buscarEnderecoPaginadoUseCase(){
        return new DefaultBuscarEnderecoPaginadoUseCase(enderecoGateway);
    }

    @Bean
    DeleteEnderecoUseCase deleteEnderecoUseCase(){
        return new DefaultDeleteEnderecoUseCase(enderecoGateway);
    }
}
