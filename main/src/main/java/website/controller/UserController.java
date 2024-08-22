package website.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.core.service.UserService;
import website.dto.UserDto;
import website.entity.UserEntity;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;
    @GetMapping("/all")
    @CrossOrigin("*")
    public ResponseEntity<List <UserDto>> getAll()  {
        List<UserDto> users = userService.findAll();
        //Thread.sleep(2000);
        return ResponseEntity.ok(users);
    }

}
