package kg.megacom.demotoken.model.request;

import kg.megacom.demotoken.model.entity.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RegisterUserRequest {
    String username;

    String email;

    String password;

    String firstName;

    String lastName;

    List<Long> roleIds;
}
