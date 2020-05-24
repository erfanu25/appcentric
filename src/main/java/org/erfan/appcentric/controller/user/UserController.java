package org.erfan.appcentric.controller.user;

import org.erfan.appcentric.configuration.jwt.JwtUtils;
import org.erfan.appcentric.configuration.services.UserDetailsImpl;
import org.erfan.appcentric.domain.User;
import org.erfan.appcentric.payload.request.LoginRequest;
import org.erfan.appcentric.payload.response.JwtResponse;
import org.erfan.appcentric.repository.UserRepository;
import org.erfan.appcentric.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;




    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail()));
    }


    @GetMapping(value = "/user")
    public List<User> user() {
        return userService.getUser();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        if (!userService.emailExist(user.getEmail())) {
            return ResponseEntity.ok(userService.saveUser(user));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("This Email Already Used");
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {
        return ResponseEntity.ok(userService.updateUser(user, id));
    }

}
