package br.com.diegosilva.seletivo.infrastructure.mapper;

import br.com.diegosilva.seletivo.domain.pessoa.ServidorEfetivo;
import br.com.diegosilva.seletivo.infrastructure.pessoa.persistence.ServidorEfetivoJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServidorEfetivoMapper {
    ServidorEfetivoMapper INSTANCE = Mappers.getMapper(ServidorEfetivoMapper.class);

    @Mapping(target = "matricula", source = "matricula")
    ServidorEfetivoJpaEntity servidorEfetivoToServidorEfetivoJpaEntity(ServidorEfetivo servidorEfetivo);

    ServidorEfetivo servidorEfetivoJpaEntityToServidorEfetivo(ServidorEfetivoJpaEntity servidorEfetivoJpaEntity);
}
