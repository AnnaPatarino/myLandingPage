package controller;

import dto.ProfileResponse;
import dto.UserRegistrationRequest;
import dto.UserResponse;
import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.impl.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(
            @RequestBody UserRegistrationRequest request) {

        User user = userService.registerUser(request);

        UserResponse response = UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .enabled(user.getEnabled())
                .build();

        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
