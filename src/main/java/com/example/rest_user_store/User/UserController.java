package com.example.rest_user_store.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUser(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED) // correct response status from this endpoint - note
    public String addUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        return "done";
    }

    @PatchMapping("/{id}/tags")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable("id") Integer id, @RequestBody String updates){
        UserEntity user = userService.findUserById(id);
        user.setTags();
    }

    @GetMapping("/{tags}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getUsers(@PathVariable("tags") String[] tags){
        userService.getUsers(tags);

        return new ResponseEntity<>(userService.getUsers(tags).toString(), HttpStatus.OK);
    }
}
