package br.com.diegosilva.seletivo.infrastructure.lotacao.presenters;


import br.com.diegosilva.seletivo.application.lotacao.BuscarLotacaoPorIdUseCase;
import br.com.diegosilva.seletivo.infrastructure.lotacao.models.LotacaoResponse;

public interface LotacaoApiPresenter {

    static LotacaoResponse present(final BuscarLotacaoPorIdUseCase.Output out){
        return new LotacaoResponse(
                out.lotId(),
                out.nomePessoa(),
                out.nomeUnidade(),
                out.siglaUnidade(),
                out.lotDataLotacao(),
                out.lotDataRemocao(),
                out.lotPortaria()
        );
    }
}
