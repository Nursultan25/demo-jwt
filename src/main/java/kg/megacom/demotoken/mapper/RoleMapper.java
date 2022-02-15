package kg.megacom.demotoken.mapper;

import kg.megacom.demotoken.model.dto.RoleDto;
import kg.megacom.demotoken.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleDto>{
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
}
