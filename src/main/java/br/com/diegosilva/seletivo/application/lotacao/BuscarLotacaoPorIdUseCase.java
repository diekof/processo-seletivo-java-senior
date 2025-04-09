package br.com.diegosilva.seletivo.application.lotacao;

import br.com.diegosilva.seletivo.application.UseCase;

import java.time.LocalDate;

public abstract class BuscarLotacaoPorIdUseCase extends UseCase<BuscarLotacaoPorIdUseCase.Input,BuscarLotacaoPorIdUseCase.Output> {
    public interface Input{
        Long lotId();
    }

    public interface Output{
        Long lotId();
        String nomePessoa();
        String nomeUnidade();
        String siglaUnidade();
        LocalDate lotDataLotacao();
        LocalDate lotDataRemocao();
        String lotPortaria();
    }
}
