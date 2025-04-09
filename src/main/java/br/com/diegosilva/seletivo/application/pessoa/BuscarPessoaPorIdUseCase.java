package br.com.diegosilva.seletivo.application.pessoa;

import br.com.diegosilva.seletivo.application.UseCase;
import br.com.diegosilva.seletivo.domain.endereco.Endereco;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaId;
import br.com.diegosilva.seletivo.domain.pessoa.ServidorEfetivo;
import br.com.diegosilva.seletivo.domain.pessoa.ServidorTemporario;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public abstract class BuscarPessoaPorIdUseCase extends UseCase<BuscarPessoaPorIdUseCase.Input,BuscarPessoaPorIdUseCase.Output> {
    public interface Input{
        Long pesId();
    }

    public interface Output{
        PessoaId pesId();
        String pesNome();
        LocalDate pesDataNascimento();
        String pesSexo();
        String pesMae();
        String pesPai();
        ServidorTemporario servidorTemp();
        ServidorEfetivo servidorEfetivo();
        List<Endereco> enderecos();
        Set<String> fotos();
    }
}
