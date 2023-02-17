package website.core.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import website.dto.UserDto;
import website.entity.UserEntity;
import website.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public List<UserDto> findAllPersonByIdAndDateOfBirth(Integer id, String dateOfBirth) {
        return userRepository.findAllByIdAndDateOfBirth(id, dateOfBirth).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private UserDto convert(UserEntity entity) {
        return new UserDto(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getDateOfBirth());
    }
}
