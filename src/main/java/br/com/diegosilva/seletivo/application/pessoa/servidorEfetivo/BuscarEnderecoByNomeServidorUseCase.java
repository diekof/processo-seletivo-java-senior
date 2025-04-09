package br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.pessoa.EnderecoFuncionalPorNomeServidorPreview;
import br.com.diegosilva.seletivo.domain.pessoa.EnderecoFuncionalPorNomeServidorSearch;

public abstract class BuscarEnderecoByNomeServidorUseCase extends UseCase<EnderecoFuncionalPorNomeServidorSearch, Pagination<EnderecoFuncionalPorNomeServidorPreview>> {
}
