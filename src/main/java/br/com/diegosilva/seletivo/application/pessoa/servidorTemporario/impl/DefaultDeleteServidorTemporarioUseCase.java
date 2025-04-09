package br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.impl;

import br.com.diegosilva.seletivo.application.pessoa.servidorTemporario.DeleteServidorTemporarioUseCase;
import br.com.diegosilva.seletivo.domain.exceptions.NotFoundException;
import br.com.diegosilva.seletivo.domain.pessoa.Pessoa;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaGateway;
import br.com.diegosilva.seletivo.domain.pessoa.PessoaId;

public class DefaultDeleteServidorTemporarioUseCase extends DeleteServidorTemporarioUseCase {

    private final PessoaGateway pessoaGateway;

    public DefaultDeleteServidorTemporarioUseCase(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public void execute(Long anIn) {
        Pessoa pessoa = pessoaGateway.pessoaOfId(new PessoaId(anIn))
                .orElseThrow(() -> NotFoundException.with("Pessoa com id %s não pode ser encontrado".formatted(anIn)));

        if(pessoa.getServidorEfetivo() == null){
            pessoaGateway.delete(pessoa.id());
        }else{
            pessoa.updateServidorTemporario(null);
            pessoaGateway.save(pessoa);
        }
    }
}
