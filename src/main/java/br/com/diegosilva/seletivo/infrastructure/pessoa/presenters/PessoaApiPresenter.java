package br.com.diegosilva.seletivo.infrastructure.pessoa.presenters;

import br.com.diegosilva.seletivo.application.pessoa.BuscarPessoaPorIdUseCase;
import br.com.diegosilva.seletivo.infrastructure.cidade.models.CidadeResponse;
import br.com.diegosilva.seletivo.infrastructure.endereco.models.EnderecoResponse;
import br.com.diegosilva.seletivo.infrastructure.pessoa.models.BuscarPessoaPorIdResponse;

public interface PessoaApiPresenter {
    static BuscarPessoaPorIdResponse present(final BuscarPessoaPorIdUseCase.Output out){
        return  new BuscarPessoaPorIdResponse(
                out.pesId().value(),
                out.pesNome(),
                out.pesDataNascimento(),
                out.pesSexo(),
                out.pesMae(),
                out.pesPai(),
                out.servidorTemp(),
                out.servidorEfetivo(),
                out.enderecos().stream().map(e -> new EnderecoResponse(
                                e.id().value(),
                                e.getEndTipoLogradouro(),
                                e.getEndLogradouro(),
                                e.getEndNumero(),
                                e.getEndBairro(),
                                new CidadeResponse(
                                        e.getCidade().id().value(),
                                        e.getCidade().getNome(),
                                        e.getCidade().getUf()
                                )
                        )).toList(),
                out.fotos()
        );
    } 
}
