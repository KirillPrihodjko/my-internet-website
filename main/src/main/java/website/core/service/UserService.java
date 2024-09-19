package website.core.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import website.config.JwtTokenProvider;
import website.dto.UserDto;
import website.entity.user.UserEntity;
import website.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

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

    public String login(UserEntity user) {
        //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        UserEntity savedUser = userRepository.findUserByEmail(user.getUsername());
        if (savedUser != null && savedUser.getPassword().equals(user.getPassword())) {
            return jwtTokenProvider.createToken(savedUser.getUsername(), savedUser.getRoles());
        }
        return null;
    }

    private UserDto convert(UserEntity entity) {
        return new UserDto(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getPassword(), entity.getEmail(), entity.getDateOfBirth(), entity.getRoles());
    }
}
