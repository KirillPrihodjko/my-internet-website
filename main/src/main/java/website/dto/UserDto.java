package website.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
}
