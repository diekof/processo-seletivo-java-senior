package br.com.diegosilva.seletivo.domain.pessoa;

import br.com.diegosilva.seletivo.domain.Pagination;

import java.time.LocalDate;
import java.util.Optional;

public interface PessoaGateway {
    PessoaId nextId();
    Optional<Pessoa> existePessoa(String nome, String paiNome, String maeNome, LocalDate dtNascimento);
    Pessoa save(Pessoa pessoa);
    Optional<Pessoa> pessoaOfId(PessoaId pessoaId);
    Pagination<ServidorEfetivoPorUnidadeIdPreview> findServidoresEfetivosByUnidade(ServidorEfetivoPorUnidadeIdSearchQuery search);
    Pagination<EnderecoFuncionalPorNomeServidorPreview> findEnderecoByNomeServidor(EnderecoFuncionalPorNomeServidorSearch search);

    void delete(PessoaId id);
}
