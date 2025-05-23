package br.com.diegosilva.seletivo.infrastructure.config.usecases;

import br.com.diegosilva.seletivo.application.unidade.*;
import br.com.diegosilva.seletivo.application.unidade.impl.*;
import br.com.diegosilva.seletivo.domain.cidade.CidadeGateway;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoGateway;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnidadeUseCaseConfig {

    private final UnidadeGateway unidadeGateway;
    private final EnderecoGateway enderecoGateway;
    private final CidadeGateway cidadeGateway;

    public UnidadeUseCaseConfig(UnidadeGateway unidadeGateway, EnderecoGateway enderecoGateway, CidadeGateway cidadeGateway) {
        this.unidadeGateway = unidadeGateway;
        this.enderecoGateway = enderecoGateway;
        this.cidadeGateway = cidadeGateway;
    }


    @Bean
    public CreateUnidadeUseCase createUnidadeUseCase(){
        return new DefaultCreateUnidadeUseCase(unidadeGateway,enderecoGateway,cidadeGateway);
    }

    @Bean
    public UpdateUnidadeUseCase updateUnidadeUseCase(){
        return new DefaultUpdateUnidadeUseCase(unidadeGateway,cidadeGateway);
    }

    @Bean
    public BuscarUnidadePorIdUseCase buscarUnidadePorIdUseCase(){
        return new DefaultBuscarUnidadePorIdUseCase(unidadeGateway);
    }

    @Bean
    public BuscarUnidadePaginadoUseCase buscarUnidadePaginadoUseCase(){
        return new DefaultBuscarUnidadePaginadoUseCase(unidadeGateway);
    }

    @Bean
    public DeleteUnidadeUseCase deleteUnidadeUseCase(){
        return new DefaultDeleteUnidadeUseCase(unidadeGateway);
    }
}
