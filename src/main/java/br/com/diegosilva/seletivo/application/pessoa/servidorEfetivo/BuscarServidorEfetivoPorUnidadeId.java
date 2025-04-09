package br.com.diegosilva.seletivo.application.pessoa.servidorEfetivo;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.Pagination;
import br.com.diegosilva.seletivo.domain.pessoa.ServidorEfetivoPorUnidadeIdSearchQuery;

import java.util.Set;

public abstract class BuscarServidorEfetivoPorUnidadeId
        extends UseCase<ServidorEfetivoPorUnidadeIdSearchQuery, Pagination<BuscarServidorEfetivoPorUnidadeId.Output>> {

    public interface Output{
        String nome();
        String unidadeNome();
        Integer idade();
        Set<String> fotos();
    }

}
