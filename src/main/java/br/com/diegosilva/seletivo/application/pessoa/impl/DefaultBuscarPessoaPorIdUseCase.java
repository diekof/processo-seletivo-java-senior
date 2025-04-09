package br.com.diegosilva.seletivo.application.pessoa.impl;

import br.com.diegosilva.seletivo.application.pessoa.BuscarPessoaPorIdUseCase;
import br.com.diegosilva.seletivo.domain.endereco.Endereco;
import br.com.diegosilva.seletivo.domain.exceptions.NotFoundException;
import br.com.diegosilva.seletivo.domain.pessoa.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultBuscarPessoaPorIdUseCase extends BuscarPessoaPorIdUseCase {

    private final PessoaGateway pessoaGateway;
    private final MediaResourceGateway mediaResourceGateway;

    public DefaultBuscarPessoaPorIdUseCase(PessoaGateway pessoaGateway, MediaResourceGateway mediaResourceGateway) {
        this.pessoaGateway = pessoaGateway;
        this.mediaResourceGateway = mediaResourceGateway;
    }

    @Override
    public Output execute(Input input) {
        final var pesId = new PessoaId((input.pesId()));
        return this.pessoaGateway
                .pessoaOfId(pesId)
                .map(p -> new StdOutput(p, mediaResourceGateway) )
                .orElseThrow(()-> NotFoundException.with("Pessoa não encontrado"));
    }

    record StdOutput(
            PessoaId pesId,
            String pesNome,
            LocalDate pesDataNascimento,
            String pesSexo,
            String pesMae,
            String pesPai,
            ServidorTemporario servidorTemp,
            ServidorEfetivo servidorEfetivo,
            List<Endereco> enderecos,
            Set<String> fotos
    ) implements BuscarPessoaPorIdUseCase.Output{

        public StdOutput(Pessoa pessoa, MediaResourceGateway mediaResourceGateway){
            this(
                  pessoa.id(),
                  pessoa.getPesNome(),
                  pessoa.getPesDataNascimento(),
                  pessoa.getPesSexo(),
                  pessoa.getPesMae(),
                  pessoa.getPesPai(),
                  pessoa.getServidorTemporario(),
                  pessoa.getServidorEfetivo(),
                  pessoa.getEnderecos(),
                  pessoa.getFotos()
                          .stream()
                          .map(f->mediaResourceGateway.generateTemporaryLink(f.getFpBucket()))
                          .collect(Collectors.toSet())
            );
        }
    }
}
