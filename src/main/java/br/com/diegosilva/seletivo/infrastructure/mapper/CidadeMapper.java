package br.com.diegosilva.seletivo.infrastructure.mapper;

import br.com.diegosilva.seletivo.domain.cidade.Cidade;
import br.com.diegosilva.seletivo.domain.cidade.CidadeId;
import br.com.diegosilva.seletivo.infrastructure.cidade.persistence.CidadeJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CidadeMapper {

    CidadeMapper INSTANCE = Mappers.getMapper(CidadeMapper.class);

    // Mapeamento de Cidade para CidadeJpaEntity
    @Mapping(target = "id", expression = "java(cidade.id().value() )")
    CidadeJpaEntity cidadeToCidadeJpaEntity(Cidade cidade);

    // Mapeamento de CidadeJpaEntity para Cidade
    @Mapping(target = "cidadeId", expression = "java(new CidadeId(cidadeJpaEntity.getId()))")
    Cidade cidadeJpaEntityToCidade(CidadeJpaEntity cidadeJpaEntity);

    default CidadeId mapToCidadeId(Long id) {
        return id != null ? new CidadeId(id) : CidadeId.empty(); // Retorna um CidadeId vazio se id for null
    }
}