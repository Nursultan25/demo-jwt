package kg.megacom.demotoken.mapper;

import java.util.List;

public interface BaseMapper<ENTITY, DTO>{
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
    List<ENTITY> toEntityList(List<DTO> dto);
    List<DTO> toDtoList(List<ENTITY> entity);
}
