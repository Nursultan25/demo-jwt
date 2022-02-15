package kg.megacom.demotoken.service;

import kg.megacom.demotoken.model.dto.UserDto;
import kg.megacom.demotoken.model.request.RegisterUserRequest;
import kg.megacom.demotoken.model.response.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto register(RegisterUserRequest registerUserRequest);
    List<UserDto> getALl();
    UserDto getOneByUserName(String username);
    UserDto getOneById(Long id);
    Response delete(Long id);
}
