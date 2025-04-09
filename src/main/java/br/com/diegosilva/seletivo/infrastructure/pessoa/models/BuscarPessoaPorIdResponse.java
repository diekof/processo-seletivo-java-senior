package br.com.diegosilva.seletivo.infrastructure.pessoa.models;

import br.com.diegosilva.seletivo.domain.pessoa.ServidorEfetivo;
import br.com.diegosilva.seletivo.domain.pessoa.ServidorTemporario;
import br.com.diegosilva.seletivo.infrastructure.endereco.models.EnderecoResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record BuscarPessoaPorIdResponse(
        Long pesId,
        String pesNome,
        LocalDate pesDataNascimento,
        String pesSexo,
        String pesMae,
        String pesPai,
        ServidorTemporario servidorTemp,
        ServidorEfetivo servidorEfetivo,
        List<EnderecoResponse> enderecos,
        Set<String> fotos
) {
}
