package br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.impl;

import br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo.BuscarEnderecoByNomeServidorUseCase;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.pessoa.EnderecoFuncionalPorNomeServidorPreview;
import br.com.diegosilva.seletivo.domain.pessoa.EnderecoFuncionalPorNomeServidorSearch;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaGateway;

public class DefaultBuscarEnderecoByNomeServidorUseCase extends BuscarEnderecoByNomeServidorUseCase {
    private PessoaGateway pessoaGateway;

    public DefaultBuscarEnderecoByNomeServidorUseCase(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public Pagination<EnderecoFuncionalPorNomeServidorPreview> execute(EnderecoFuncionalPorNomeServidorSearch enderecoFuncionalPorNomeServidorSearch) {
        return pessoaGateway.findEnderecoByNomeServidor(enderecoFuncionalPorNomeServidorSearch);
    }
}
