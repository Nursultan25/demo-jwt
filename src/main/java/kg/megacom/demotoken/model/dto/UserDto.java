package kg.megacom.demotoken.model.dto;

import kg.megacom.demotoken.model.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;

    String username;

    String email;

    String password;

    String firstName;

    String lastName;

    List<RoleDto> roles;
}
