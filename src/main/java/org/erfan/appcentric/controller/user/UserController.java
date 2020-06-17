package org.erfan.appcentric.controller.user;

import org.erfan.appcentric.domain.User;
import org.erfan.appcentric.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

//    private UserService userService;
//
//    public UserController(UserService userService){
//        this.userService = userService;
//    }

//    @Resource
    @Autowired
    private UserService userService;

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

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        if(!userService.emailExist(user.getEmail())) {
            return ResponseEntity.ok(userService.saveUser(user));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("This Email Already Used");
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {
        return ResponseEntity.ok(userService.updateUser(user,id));
    }

}
