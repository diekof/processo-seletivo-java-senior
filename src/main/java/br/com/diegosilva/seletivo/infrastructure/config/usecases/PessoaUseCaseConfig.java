package br.com.diegosilva.seletivo.infrastructure.config.usecases;

import br.com.diegosilva.seletivo.application.pessoa.BuscarPessoaPorIdUseCase;
import br.com.diegosilva.seletivo.application.pessoa.UploadFotoUseCase;
import br.com.diegosilva.seletivo.application.pessoa.impl.DefaultBuscarPessoaPorIdUseCase;
import br.com.diegosilva.seletivo.application.pessoa.impl.DefaultUploadFotoUseCase;
import br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.*;
import br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.impl.*;
import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.CreateServidorTemporarioUseCase;
import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.DeleteServidorTemporarioUseCase;
import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.UpdateServidorTemporarioUseCase;
import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.impl.DefaultCreateServidorTemporarioUseCase;
import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.impl.DefaultDeleteServidorTemporarioUseCase;
import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.impl.DefaultUpdateServidorTemporarioUseCase;
import br.com.diegosilva.seletivo.domain.cidade.CidadeGateway;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoGateway;
import br.com.diegosilva.seletivo.domain.lotacao.LotacaoGateway;
import br.com.diegosilva.seletivo.domain.pessoa.MediaResourceGateway;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaUseCaseConfig {
    private final PessoaGateway pessoaGateway;
    private final EnderecoGateway enderecoGateway;
    private final MediaResourceGateway mediaResourceGateway;
    private final CidadeGateway cidadeGateway;
    private final LotacaoGateway lotacaoGateway;

    public PessoaUseCaseConfig(PessoaGateway pessoaGateway,
                               EnderecoGateway enderecoGateway,
                               MediaResourceGateway mediaResourceGateway,
                               CidadeGateway cidadeGateway,
                               LotacaoGateway lotacaoGateway) {
        this.pessoaGateway = pessoaGateway;
        this.enderecoGateway = enderecoGateway;
        this.mediaResourceGateway = mediaResourceGateway;
        this.cidadeGateway = cidadeGateway;
        this.lotacaoGateway = lotacaoGateway;
    }

    @Bean
    public CreateServidorEfetivoUseCase servidorEfetivoUseCase(){
        return new DefaultCreateServidorEfetivoUseCase(pessoaGateway,enderecoGateway,cidadeGateway);
    }

    @Bean
    public UploadFotoUseCase uploadFotoUseCase(){
        return new DefaultUploadFotoUseCase(pessoaGateway,mediaResourceGateway);
    }

    @Bean
    public UpdateServidorEfetivoUseCase updateServidorEfetivoUseCase(){
        return new DefaultUpdateServidorEfetivoUseCase(pessoaGateway,enderecoGateway,cidadeGateway);
    }

    @Bean
    public CreateServidorTemporarioUseCase createServidorTemporarioUseCase(){
        return new DefaultCreateServidorTemporarioUseCase(pessoaGateway,enderecoGateway,cidadeGateway);
    }

    @Bean
    public UpdateServidorTemporarioUseCase updateServidorTemporarioUseCase(){
        return new DefaultUpdateServidorTemporarioUseCase(pessoaGateway,enderecoGateway,cidadeGateway);
    }

    @Bean
    public BuscarPessoaPorIdUseCase buscarPessoaPorIdUseCase(){
        return new DefaultBuscarPessoaPorIdUseCase(pessoaGateway,mediaResourceGateway);
    }

    @Bean
    public BuscarServidorEfetivoPorUnidadeId buscarServidorEfetivoPorUnidadeId(){
        return new DefaultBuscarServidorEfetivoPorUnidadeId(mediaResourceGateway,pessoaGateway);
    }

    @Bean
    public BuscarEnderecoByNomeServidorUseCase buscarEnderecoByNomeServidorUseCase(){
        return  new DefaultBuscarEnderecoByNomeServidorUseCase(pessoaGateway);
    }

    @Bean
    public DeleteServidorTemporarioUseCase deleteServidorTemporarioUseCase(){
        return new DefaultDeleteServidorTemporarioUseCase(pessoaGateway);
    }

    @Bean
    public DeleteServidorEfetivoUseCase deleteServidorEfetivoUseCase(){
        return new DefeultDeleteServidorEfetivoUseCase(pessoaGateway,mediaResourceGateway,lotacaoGateway);
    }
}
