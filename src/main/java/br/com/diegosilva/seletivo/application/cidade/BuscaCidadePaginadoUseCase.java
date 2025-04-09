package br.com.diegosilva.seletivo.application.cidade;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.cidade.CidadePreview;
import br.com.diegosilva.seletivo.domain.cidade.CidadeSearchQuery;

public abstract class BuscaCidadePaginadoUseCase
        extends UseCase<CidadeSearchQuery, Pagination<CidadePreview>> {


}
