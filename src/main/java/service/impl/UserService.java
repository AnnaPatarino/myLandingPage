package service.impl;

import dto.UserRegistrationRequest;
import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(UserRegistrationRequest request){

        Optional<User> userEmail = userRepository.findByEmail(request.getEmail());

        if(userEmail.isPresent()){
            throw new RuntimeException("registerUser - User already exist");
        }

           User newUser = User.builder()
                            .username(request.getUsername())
                            .email(request.getEmail())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .role("USER")
                            .enabled(true).build();

        return userRepository.save(newUser);
    }

}