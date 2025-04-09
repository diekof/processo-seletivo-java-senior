package br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.impl;

import br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.BuscarServidorEfetivoPorUnidadeId;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.pessoa.MediaResourceGateway;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaGateway;
import br.com.diegosilva.seletivo.domain.pessoa.ServidorEfetivoPorUnidadeIdSearchQuery;

import java.util.Set;
import java.util.stream.Collectors;


public class DefaultBuscarServidorEfetivoPorUnidadeId extends BuscarServidorEfetivoPorUnidadeId {

    private final MediaResourceGateway mediaResourceGateway;
    private final PessoaGateway pessoaGateway;

    public DefaultBuscarServidorEfetivoPorUnidadeId(MediaResourceGateway mediaResourceGateway, PessoaGateway pessoaGateway) {
        this.mediaResourceGateway = mediaResourceGateway;
        this.pessoaGateway = pessoaGateway;
    }


    @Override
    public Pagination<Output> execute(ServidorEfetivoPorUnidadeIdSearchQuery servidorEfetivoPorUnidadeIdSearchQuery) {

        return pessoaGateway
                .findServidoresEfetivosByUnidade(servidorEfetivoPorUnidadeIdSearchQuery)
                .map(p -> new StdOutput(
                        p.nome(),
                        p.unidadeLotacao(),
                        p.idade(),
                        p.fotos()
                                .stream()
                                .map(mediaResourceGateway::generateTemporaryLink)
                                .collect(Collectors.toSet())
                ));
    }
    
    
    record StdOutput(
            String nome,
            String unidadeNome,
            Integer idade,
            Set<String> fotos
    ) implements Output {


    }
}
