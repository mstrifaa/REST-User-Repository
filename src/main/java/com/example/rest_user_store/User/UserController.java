package com.example.rest_user_store.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED) // correct response status from this endpoint - note
    public String addUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        return "done";
    }
}
