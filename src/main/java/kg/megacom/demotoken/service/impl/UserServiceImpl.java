package kg.megacom.demotoken.service.impl;

import kg.megacom.demotoken.mapper.UserMapper;
import kg.megacom.demotoken.model.dto.UserDto;
import kg.megacom.demotoken.model.request.RegisterUserRequest;
import kg.megacom.demotoken.model.response.Response;
import kg.megacom.demotoken.repository.UserRepository;
import kg.megacom.demotoken.service.RoleService;
import kg.megacom.demotoken.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final RoleService roleService;
    final PasswordEncoder passwordEncoder;

    @Override
    public UserDto register(RegisterUserRequest registerUserRequest) {
        UserDto user = UserDto
                .builder()
                .username(registerUserRequest.getUsername())
                .firstName(registerUserRequest.getFirstName())
                .lastName(registerUserRequest.getLastName())
                .password(passwordEncoder.encode(registerUserRequest.getPassword()))
                .email(registerUserRequest.getEmail())
                .roles(roleService.findAllById(registerUserRequest.getRoleIds()))
                .build();
        userRepository.save(UserMapper.INSTANCE.toEntity(user));
        return user;
    }

    @Override
    public List<UserDto> getALl() {
        return null;
    }

    @Override
    public UserDto getOneByUserName(String username) {
        UserDto user = UserMapper.INSTANCE.toDto(userRepository.findByUsernameAndIsDeletedFalse(username)
                .orElseThrow(() -> new RuntimeException("User not found or deleted")));
        return user;
    }

    @Override
    public UserDto getOneById(Long id) {
        return null;
    }

    @Override
    public Response delete(Long id) {
        return null;
    }
}
