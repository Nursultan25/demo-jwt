package kg.megacom.demotoken.security;

import kg.megacom.demotoken.mapper.UserMapper;
import kg.megacom.demotoken.model.dto.UserDto;
import kg.megacom.demotoken.model.entity.User;
import kg.megacom.demotoken.security.jwt.JwtUser;
import kg.megacom.demotoken.security.jwt.JwtUserFactory;
import kg.megacom.demotoken.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {
    final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = UserMapper.INSTANCE.toEntity(userService.getOneByUserName(username));

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}
