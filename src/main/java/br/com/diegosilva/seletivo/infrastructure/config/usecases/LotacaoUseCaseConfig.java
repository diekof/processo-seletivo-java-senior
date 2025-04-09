package br.com.diegosilva.seletivo.infrastructure.config.usecases;

import br.com.diegosilva.seletivo.application.lotacao.BuscarLotacaoPorIdUseCase;
import br.com.diegosilva.seletivo.application.lotacao.CreateLotacaoUseCase;
import br.com.diegosilva.seletivo.application.lotacao.DeleteLotacaoUseCase;
import br.com.diegosilva.seletivo.application.lotacao.UpdateLotacaoUseCase;
import br.com.diegosilva.seletivo.application.lotacao.impl.DefaultBuscarLotacaoPorIdUseCase;
import br.com.diegosilva.seletivo.application.lotacao.impl.DefaultCreateLotacaoUseCase;
import br.com.diegosilva.seletivo.application.lotacao.impl.DefaultDeleteLotacaoUseCase;
import br.com.diegosilva.seletivo.application.lotacao.impl.DefaultUpdateLotacaoUseCase;
import br.com.diegosilva.seletivo.domain.lotacao.LotacaoGateway;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaGateway;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LotacaoUseCaseConfig {
    private final PessoaGateway pessoaGateway;
    private final UnidadeGateway unidadeGateway;
    private final LotacaoGateway lotacaoGateway;

    public LotacaoUseCaseConfig(
            PessoaGateway pessoaGateway,
            UnidadeGateway unidadeGateway,
            LotacaoGateway lotacaoGateway) {

        this.pessoaGateway = pessoaGateway;
        this.unidadeGateway = unidadeGateway;
        this.lotacaoGateway = lotacaoGateway;
    }


    @Bean
    public CreateLotacaoUseCase createLotacaoUseCase(){
        return new DefaultCreateLotacaoUseCase(
                lotacaoGateway,
                pessoaGateway,
                unidadeGateway
        );
    }

    @Bean
    public UpdateLotacaoUseCase updateLotacaoUseCase(){
        return new DefaultUpdateLotacaoUseCase(
                lotacaoGateway,
                pessoaGateway,
                unidadeGateway
        );
    }

    @Bean
    public BuscarLotacaoPorIdUseCase buscarLotacaoPorIdUseCase(){
        return new DefaultBuscarLotacaoPorIdUseCase(lotacaoGateway);
    }

    @Bean
    public DeleteLotacaoUseCase deleteLotacaoUseCase(){
        return new DefaultDeleteLotacaoUseCase(lotacaoGateway);
    }
}
