package br.com.diegosilva.seletivo.application.unidade;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.unidade.UnidadePreview;
import br.com.diegosilva.seletivo.domain.unidade.UnidadeSearchQuery;

public abstract class BuscarUnidadePaginadoUseCase  extends UseCase<UnidadeSearchQuery, Pagination<UnidadePreview>> {
}
