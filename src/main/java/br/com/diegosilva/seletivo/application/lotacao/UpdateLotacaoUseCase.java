package br.com.diegosilva.seletivo.application.lotacao;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.lotacao.LotacaoId;

import java.time.LocalDate;

public abstract class UpdateLotacaoUseCase extends UseCase<UpdateLotacaoUseCase.Input,UpdateLotacaoUseCase.Output> {

    public interface Input{
        Long lotId();
        Long pesId();
        Long unidId();
        LocalDate lotDataLotacao();
        LocalDate lotDataRemocao();
        String lotPortaria();
    }
    public interface Output{
        LotacaoId lotId();
    }
}
