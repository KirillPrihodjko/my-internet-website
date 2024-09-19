package website.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import website.entity.user.Role;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String dateOfBirth;
    private Set<Role> roles;
}
