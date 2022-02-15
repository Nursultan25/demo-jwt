package kg.megacom.demotoken.mapper;

import kg.megacom.demotoken.model.dto.UserDto;
import kg.megacom.demotoken.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto>{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
