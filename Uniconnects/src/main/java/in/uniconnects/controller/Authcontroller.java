package in.uniconnects.controller;

import in.uniconnects.model.entity.User;
import in.uniconnects.model.request.CreateUserRequest;
import in.uniconnects.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class Authcontroller {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public User createUser(@RequestBody CreateUserRequest createUserRequest) {

        if (createUserRequest.getName() != null && createUserRequest.getPassword() != null && createUserRequest.getUsername() != null && createUserRequest.getPhoneNumber() != null) {

            User user = new User(createUserRequest.getName(), createUserRequest.getUsername(), passwordEncoder.encode(createUserRequest.getPassword()), createUserRequest.getEmail(), createUserRequest.getPhoneNumber());
            userRepository.save(user);

            return user;
        }
        return null;

    }


}
