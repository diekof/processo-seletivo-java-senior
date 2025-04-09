package br.com.diegosilva.seletivo.application;

public record CreateEnderecoCommand(String endTipoLogradouro,
                                    String endLogradouro,
                                    Integer endNumero,
                                    String endBairro,
                                    Long cidadeId) {
}
