package website.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.core.service.UserService;
import website.dto.UserDto;
import website.entity.user.UserEntity;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    @CrossOrigin("*")
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> users = userService.findAll();
        //Thread.sleep(2000);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<?> login(@RequestBody UserEntity userEntity) {
        //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        String token = userService.login(userEntity);
        if (token != null) {
            return ResponseEntity.status(HttpStatus.OK).body(token);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist. Check login and password!");
    }
}
