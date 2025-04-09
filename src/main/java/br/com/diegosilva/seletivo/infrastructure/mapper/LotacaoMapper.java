package br.com.diegosilva.seletivo.infrastructure.mapper;

import br.com.diegosilva.seletivo.domain.lotacao.Lotacao;
import br.com.diegosilva.seletivo.infrastructure.lotacao.persistence.LotacaoJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( uses = {LotacaoMapper.class, PessoaMapper.class, UnidadeMapper.class})
public interface LotacaoMapper {

    LotacaoMapper INSTANCE = Mappers.getMapper(LotacaoMapper.class);

    @Mapping(target = "lotId", expression = "java(lotacao.id().value() )")
    LotacaoJpaEntity lotacaoToLotacaoJpaEntity(Lotacao lotacao);

    @Mapping(target = "lotacaoId", expression = "java(new LotacaoId(lotacaoJpaEntity.getLotId()))")
    Lotacao lotacaJpaEntityToLotacao(LotacaoJpaEntity lotacaoJpaEntity);
}
