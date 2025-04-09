package br.com.diegosilva.seletivo.application.endereco;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoPreview;
import br.com.diegosilva.seletivo.domain.endereco.EnderecoSearchQuery;

public abstract class BuscarEnderecoPaginadoUseCase
        extends UseCase<EnderecoSearchQuery, Pagination<EnderecoPreview>> {
}
